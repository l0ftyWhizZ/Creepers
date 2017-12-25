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
package org.terasology.creepers.actions;

import org.terasology.behaviors.components.FindNearbyPlayersComponent;
import org.terasology.behaviors.components.FollowComponent;
import org.terasology.creepers.component.CreeperComponent;
import org.terasology.logic.behavior.BehaviorAction;
import org.terasology.logic.behavior.core.Actor;
import org.terasology.logic.behavior.core.BaseAction;
import org.terasology.logic.behavior.core.BehaviorState;
import org.terasology.logic.location.LocationComponent;
import org.terasology.math.geom.Vector3f;


@BehaviorAction(name = "CheckFollowStatus")
public class FollowCharacterAction extends BaseAction {

    @Override
    public void construct(Actor actor) {
        FollowComponent followComponent = new FollowComponent();
        FindNearbyPlayersComponent component = actor.getComponent(FindNearbyPlayersComponent.class);
        followComponent.entityToFollow = component.closestCharacter;
        actor.save(followComponent);
        float maxDistance =  actor.getComponent(CreeperComponent.class).maxDistanceTillExplode;
        Vector3f currentPlayerLocation = followComponent.entityToFollow.getComponent(LocationComponent.class).getWorldPosition();
        Vector3f currentActorLocation = actor.getComponent(LocationComponent.class).getWorldPosition();

        if (currentActorLocation.distanceSquared(currentPlayerLocation) < maxDistance * maxDistance) {

        }
    }

    @Override
    public BehaviorState modify(Actor actor, BehaviorState result) {
        return BehaviorState.SUCCESS;
    }
}

