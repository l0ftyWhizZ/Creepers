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
package org.terasology.creepers.component;

import org.terasology.entitySystem.Component;

public class CreeperUtils implements Component {
    private float walkSpeed = 10f;
    private float chaseSpeed = 20f;
    private float playerDetectRadius = 25f;
    private float explosionFactor = 25f;

    public CreeperUtils () {
        /*
            Default constructor. Use pre-defined values for the fields.
         */
    }

    public CreeperUtils (float walkSpeed, float chaseSpeed, float playerDetectRadius, float explosionFactor) {
        setWalkSpeed(walkSpeed);
        setChaseSpeed(chaseSpeed);
        setPlayerDetectRadius(playerDetectRadius);
        setExplosionFactor(explosionFactor);
    }

    public float getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(float walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public float getChaseSpeed() {
        return chaseSpeed;
    }

    public void setChaseSpeed(float chaseSpeed) {
        this.chaseSpeed = chaseSpeed;
    }

    public float getPlayerDetectRadius() {
        return playerDetectRadius;
    }

    public void setPlayerDetectRadius(float playerDetectRadius) {
        this.playerDetectRadius = playerDetectRadius;
    }

    public float getExplosionFactor() {
        return explosionFactor;
    }

    public void setExplosionFactor(float explosionFactor) {
        this.explosionFactor = explosionFactor;
    }
}
