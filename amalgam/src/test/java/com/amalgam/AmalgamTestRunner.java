package com.amalgam;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

/**
 * @author KeishinYokomaku
 */
public class AmalgamTestRunner extends RobolectricGradleTestRunner {
	public AmalgamTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
	}

	@Override
	protected AndroidManifest getAppManifest(Config config) {
		return new AndroidManifest(
				Fs.fileFromPath("../amalgam/src/main/AndroidManifest.xml"),
				Fs.fileFromPath("../amalgam/build/intermediates/res/merged/" + BuildConfig.FLAVOR + "/debug"),
				Fs.fileFromPath("../amalgam/build/intermediates/assets/" + BuildConfig.FLAVOR + "/debug/"));
	}
}
