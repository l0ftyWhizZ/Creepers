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

public class CreeperComponent implements Component {
    /* The maximum distance a creeper can have from a player, before exploding. */
    public float maxDistanceTillExplode = 10f;
    /* The delay between the instances when the creeper explodes, and when it starts fusing up. */
    public long explosionDelay = 2;
}
