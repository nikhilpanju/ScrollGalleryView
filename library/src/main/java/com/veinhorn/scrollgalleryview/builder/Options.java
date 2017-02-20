package com.veinhorn.scrollgalleryview.builder;

/**
 * Created by veinhorn on 20.2.17.
 */

public class Options {
    private static final int DEFAULT_THUMBNAIL_SIZE = 100;

    private int thumbnailsSize;
    private boolean zoomEnabled;

    private Options() {

    }

    private Options(int thumbnailsSize, boolean zoomEnabled) {
        this.thumbnailsSize = thumbnailsSize;
        this.zoomEnabled = zoomEnabled;
    }

    public static Options defaultOptions() {
        return new Options(DEFAULT_THUMBNAIL_SIZE, false);
    }

    public static OptionsBuilder builder() {
        return new OptionsBuilderImpl();
    }

    public boolean isZoomEnabled() {
        return zoomEnabled;
    }

    public void setThumbnailsSize(int thumbnailsSize) {
        this.thumbnailsSize = thumbnailsSize;
    }

    public void setZoomEnabled(boolean zoomEnabled) {
        this.zoomEnabled = zoomEnabled;
    }

    public int getThumbnailsSize() {
        return thumbnailsSize;
    }

    public interface OptionsBuilder {
        OptionsBuilder setThumbnailSize(int thumbnailSize);
        OptionsBuilder setZoom(boolean zoomEnabled);
        Options build();
    }

    private static class OptionsBuilderImpl implements OptionsBuilder {
        private Options options = new Options();

        @Override
        public OptionsBuilder setThumbnailSize(int thumbnailSize) {
            options.setThumbnailsSize(thumbnailSize);
            return this;
        }

        @Override
        public OptionsBuilder setZoom(boolean zoomEnabled) {
            options.setZoomEnabled(zoomEnabled);
            return this;
        }

        @Override
        public Options build() {
            return options;
        }
    }
}
