package com.veinhorn.scrollgalleryview.builder;

import android.support.v4.app.FragmentManager;

import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;
import com.veinhorn.scrollgalleryview.builder.essential.OptionsInitializer;

import java.util.List;

/**
 * Created by veinhorn on 20.2.17.
 */

public abstract class GalleryBuilder {
    public static OptionsInitializer from(ScrollGalleryView gallery, FragmentManager manager) {
        return new GalleryBuilderImpl(gallery, manager);
    }

    public abstract GalleryBuilder addMedia(MediaInfo mediaInfo);
    public abstract GalleryBuilder addMedia(List<String> urls);
    public abstract ScrollGalleryView build();
}
