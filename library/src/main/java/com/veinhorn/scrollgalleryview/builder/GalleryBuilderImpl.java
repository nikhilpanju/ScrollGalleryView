package com.veinhorn.scrollgalleryview.builder;

import android.support.v4.app.FragmentManager;

import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;
import com.veinhorn.scrollgalleryview.builder.essential.OptionsInitializer;
import com.veinhorn.scrollgalleryview.loader.PicassoImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veinhorn on 20.2.17.
 */

public class GalleryBuilderImpl extends GalleryBuilder implements OptionsInitializer {
    private ScrollGalleryView gallery;
    private FragmentManager manager;

    protected GalleryBuilderImpl(ScrollGalleryView gallery, FragmentManager manager) {
        this.gallery = gallery;
        this.manager = manager;
    }

    @Override
    public GalleryBuilder withOptions(Options options) {
        gallery.setThumbnailSize(options.getThumbnailsSize());
        gallery.setZoom(options.isZoomEnabled());
        gallery.setFragmentManager(manager);
        return this;
    }

    @Override
    public GalleryBuilder addMedia(MediaInfo mediaInfo) {
        gallery.addMedia(mediaInfo);
        return this;
    }

    @Override
    public GalleryBuilder addMedia(List<String> urls) {
        List<MediaInfo> infos = new ArrayList<>(urls.size());
        for (String url : urls) infos.add(MediaInfo.mediaLoader(new PicassoImageLoader(url)));
        gallery.addMedia(infos);
        return this;
    }

    @Override
    public ScrollGalleryView build() {
        return gallery;
    }
}
