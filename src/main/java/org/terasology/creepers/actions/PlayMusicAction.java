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

import org.terasology.assets.ResourceUrn;
import org.terasology.assets.management.AssetManager;
import org.terasology.audio.AudioEndListener;
import org.terasology.audio.AudioManager;
import org.terasology.audio.StreamingSound;
import org.terasology.logic.behavior.BehaviorAction;
import org.terasology.logic.behavior.core.Actor;
import org.terasology.logic.behavior.core.BaseAction;
import org.terasology.logic.behavior.core.BehaviorState;
import org.terasology.module.sandbox.API;
import org.terasology.registry.In;
import org.terasology.rendering.nui.properties.OneOf;
import org.terasology.rendering.nui.properties.Range;

/**
 * Plays music in background. Return SUCCESS when music ends.
 */
@API
@BehaviorAction(name = "music")
public class PlayMusicAction extends BaseAction {
    @OneOf.Provider(name = "music")
    private ResourceUrn musicUrn;
    @Range(min = 0, max = 1)
    private float volume;
    @In
    private transient AudioManager audioManager;
    @In
    private transient AssetManager assetManager;

    @Override
    public void construct(Actor actor) {
        if (musicUrn != null) {

            StreamingSound snd = assetManager.getAsset(musicUrn, StreamingSound.class).orElse(null);

            if (snd != null) {
                audioManager.playMusic(snd, volume, createEndListener(actor));
                actor.setValue(getId(), true);
            }
        }
    }

    @Override
    public BehaviorState modify(Actor actor, BehaviorState result) {
        Boolean playing = actor.getValue(getId());
        if (playing == null || !playing) {
            return BehaviorState.SUCCESS;
        }
        return BehaviorState.RUNNING;
    }

    private AudioEndListener createEndListener(final Actor actor) {
        return (boolean interrupted) -> actor.setValue(getId(), false);
    }

}
