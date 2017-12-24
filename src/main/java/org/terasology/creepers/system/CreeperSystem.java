/*
 * Copyright 2017 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.creepers.system;

import org.terasology.creepers.component.CreeperComponent;
import org.terasology.creepers.UpdateBehaviorEvent;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.assets.management.AssetManager;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.entitySystem.systems.RegisterMode;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.event.EventPriority;
import org.terasology.logic.characters.CharacterMovementComponent;
import org.terasology.behaviors.components.FindNearbyPlayersComponent;
import org.terasology.behaviors.components.FollowComponent;
import org.terasology.logic.behavior.BehaviorComponent;
import org.terasology.logic.behavior.asset.BehaviorTree;
import org.terasology.registry.In;

@RegisterSystem(RegisterMode.AUTHORITY)
public class CreeperSystem extends BaseComponentSystem {
    @In
    private AssetManager assetManager;

    @ReceiveEvent(priority = EventPriority.PRIORITY_HIGH, components = CreeperComponent.class)
    public void onUpdateBehaviorAttack(UpdateBehaviorEvent event, EntityRef entity, CreeperComponent attackInProximityComponent, FindNearbyPlayersComponent findNearbyPlayersComponent) {
        if (findNearbyPlayersComponent.charactersWithinRange != null && findNearbyPlayersComponent.charactersWithinRange.size() > 0) {
            event.consume();
            EntityRef someCharacterWithinRange = findNearbyPlayersComponent.charactersWithinRange.get(0);
            FollowComponent followComponent = new FollowComponent();
            followComponent.entityToFollow = someCharacterWithinRange;
            entity.addOrSaveComponent(followComponent);

            BehaviorComponent behaviorComponent = entity.getComponent(BehaviorComponent.class);
            behaviorComponent.tree = assetManager.getAsset("Behaviors:hostileCritter", BehaviorTree.class).get();

            CharacterMovementComponent characterMovementComponent = entity.getComponent(CharacterMovementComponent.class);
            characterMovementComponent.speedMultiplier = attackInProximityComponent.speedMultiplier;
            entity.saveComponent(characterMovementComponent);
            entity.saveComponent(behaviorComponent);
        } else {
            if (entity.hasComponent(FollowComponent.class)) {
                entity.removeComponent(FollowComponent.class);
            }
        }
    }
}
//    private static final int CREEPER_GROUP_SIZE = 50;
//    private static final int SPAWN_CHANCE_IN_PERCENT = 50;
//
//    @In
//    private EntityManager entityManager;
//
//    @In
//    private WorldProvider worldProvider;
//
//    @In
//    private BlockManager blockManager;
//
//    private Prefab creeperPrefab;
//    private Random random = new Random();
//
//    @Override
//    public void initialise() {
//        creeperPrefab = Assets.getPrefab("core:door").get();
//    }
//
//    @ReceiveEvent
//    public void onChunkGenerated(OnChunkGenerated event, EntityRef worldEntity) {
//        boolean trySpawn = SPAWN_CHANCE_IN_PERCENT > random.nextInt(100);
//        if (!trySpawn) {
//            return;
//        }
//        Vector3i chunkPos = event.getChunkPos();
//        spawnCreepersOnChunk(chunkPos);
//    }
//
//    private void spawnCreepersOnChunk(Vector3i chunkPos) {
//        List<Vector3i> foundPositions = findSpawnPositions(chunkPos);
//
//        if (foundPositions.size() < CREEPER_GROUP_SIZE * CREEPER_GROUP_SIZE) {
//            return;
//        }
//
//        int creeperCount = foundPositions.size() / CREEPER_GROUP_SIZE;
//        if (creeperCount > CREEPER_GROUP_SIZE) {
//            creeperCount = CREEPER_GROUP_SIZE;
//        }
//
//        for (int i = 0; i < creeperCount; i++ ) {
//            int randomIndex = random.nextInt(foundPositions.size());
//            Vector3i randomSpawnPosition = foundPositions.remove(randomIndex);
//            spawnCreeperAtLocation(randomSpawnPosition);
//        }
//    }
//
//    private List<Vector3i> findSpawnPositions(Vector3i chunkPos) {
//        Vector3i worldPos = new Vector3i(chunkPos);
//        worldPos.mul(ChunkConstants.SIZE_X, ChunkConstants.SIZE_Y, ChunkConstants.SIZE_Z);
//        List<Vector3i> foundPositions = Lists.newArrayList();
//        Vector3i blockPos = new Vector3i();
//        for (int y = ChunkConstants.SIZE_Y - 1; y >= 0; y--) {
//            for (int z = 0; z < ChunkConstants.SIZE_Z; z++) {
//                for (int x = 0; x < ChunkConstants.SIZE_X; x++) {
//                    blockPos.set(x + worldPos.x, y + worldPos.y, z + worldPos.z);
//                    if (isValidSpawnPosition(blockPos))
//                        foundPositions.add(new Vector3i(blockPos));
//                }
//            }
//        }
//        return foundPositions;
//    }
//
//    private boolean isValidSpawnPosition(Vector3i pos) {
//        Block blockAtPosition = worldProvider.getBlock(pos);
//        if (!blockAtPosition.isPenetrable()) {
//            return false;
//        }
//        return true;
//    }
//
//    private void spawnCreeperAtLocation(Vector3i location) {
//        Vector3f floatVectorLocation = location.toVector3f();
//        Vector3f yAxis = new Vector3f(0, 1, 0);
//        float randomAngle = (float) (random.nextFloat() * Math.PI * 2);
//        Quat4f rotation = new Quat4f(yAxis, randomAngle);
//        entityManager.create(creeperPrefab, floatVectorLocation, rotation);
//    }
//}
