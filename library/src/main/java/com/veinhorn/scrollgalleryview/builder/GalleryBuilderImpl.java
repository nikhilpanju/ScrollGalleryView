package com.veinhorn.scrollgalleryview.builder;

import android.support.v4.app.FragmentManager;

import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;
import com.veinhorn.scrollgalleryview.loader.PicassoImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veinhorn on 20.2.17.
 */

public class GalleryBuilderImpl extends GalleryBuilder implements ThumbnailInitializer {
    private ScrollGalleryView gallery;

    protected GalleryBuilderImpl(ScrollGalleryView gallery, FragmentManager manager) {
        this.gallery = gallery;
        this.gallery.setFragmentManager(manager);
    }

    @Override
    public GalleryBuilder setThumbnailSize(int thumbnailSize) {
        gallery.setThumbnailSize(thumbnailSize);
        return this;
    }

    @Override
    public GalleryBuilder addMedia(MediaInfo mediaInfo) {

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
