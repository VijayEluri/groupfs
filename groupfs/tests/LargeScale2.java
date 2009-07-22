package groupfs.tests;

import groupfs.backend.*;

import fuse.FuseException;

import groupfs.*;

// shows validation in deleting tag
public class LargeScale2 extends Test {
	public void run() {
		JournalingBackend backend = getNewBackend();
		syn(backend, "old.jpg");
		syn(backend, "old2.jpg");
		syn(backend, "1.jpg", "Concert", "jpg");
		syn(backend, "2.jpg", "Concert", "jpg");
		syn(backend, "3.jpg", "Concert", "jpg");
		syn(backend, "4.jpg", "Concert", "Portrait", "Family");
		syn(backend, "5.jpg", "Concert", "Portrait", "Family");
		syn(backend, "6.jpg", "Concert", "Portrait", "Eric");
		syn(backend, "7.jpg", "Concert", "Water");
		syn(backend, "8.jpg", "Concert", "Architecture");
		syn(backend, "9.jpg", "Festival", "Competition");
		syn(backend, "10.jpg", "Festival", "Portrait", "Family");
		syn(backend, "11.jpg", "Festival", "Portrait", "Eric");
		Filesystem fs = new Filesystem(backend);
		try {
			fs.rename("/jpg/1.jpg", "/1.jpg");
		} catch (FuseException e) {
			log += e;
			error = true;
			return;
		}
		expect(fs,
			new String[] {
				"./.Trash/old.jpg",
				"./.Trash/old2.jpg",
				"./.jpg/10.jpg",
				"./.jpg/11.jpg",
				"./.jpg/1.jpg",
				"./.jpg/2.jpg",
				"./.jpg/3.jpg",
				"./.jpg/4.jpg",
				"./.jpg/5.jpg",
				"./.jpg/6.jpg",
				"./.jpg/7.jpg",
				"./.jpg/8.jpg",
				"./.jpg/9.jpg",
				"./Architecture/8.jpg",
				"./jpg/2.jpg",
				"./jpg/3.jpg",
				"./Competition/9.jpg",
				"./Concert/1.jpg",
				"./Concert/2.jpg",
				"./Concert/3.jpg",
				"./Concert/4.jpg",
				"./Concert/5.jpg",
				"./Concert/6.jpg",
				"./Concert/7.jpg",
				"./Concert/8.jpg",
				"./Concert/Architecture/8.jpg",
				"./Concert/jpg/2.jpg",
				"./Concert/jpg/3.jpg",
				"./Concert/Eric/6.jpg",
				"./Concert/Family/4.jpg",
				"./Concert/Family/5.jpg",
				"./Concert/Portrait/4.jpg",
				"./Concert/Portrait/5.jpg",
				"./Concert/Portrait/6.jpg",
				"./Concert/Portrait/Eric/6.jpg",
				"./Concert/Portrait/Family/4.jpg",
				"./Concert/Portrait/Family/5.jpg",
				"./Concert/Water/7.jpg",
				"./Eric/11.jpg",
				"./Eric/6.jpg",
				"./Eric/Concert/6.jpg",
				"./Eric/Festival/11.jpg",
				"./Family/10.jpg",
				"./Family/4.jpg",
				"./Family/5.jpg",
				"./Family/Concert/4.jpg",
				"./Family/Concert/5.jpg",
				"./Family/Festival/10.jpg",
				"./Festival/10.jpg",
				"./Festival/11.jpg",
				"./Festival/9.jpg",
				"./Festival/Competition/9.jpg",
				"./Festival/Eric/11.jpg",
				"./Festival/Family/10.jpg",
				"./Festival/Portrait/10.jpg",
				"./Festival/Portrait/11.jpg",
				"./Festival/Portrait/Eric/11.jpg",
				"./Festival/Portrait/Family/10.jpg",
				"./Portrait/10.jpg",
				"./Portrait/11.jpg",
				"./Portrait/4.jpg",
				"./Portrait/5.jpg",
				"./Portrait/6.jpg",
				"./Portrait/Concert/4.jpg",
				"./Portrait/Concert/5.jpg",
				"./Portrait/Concert/6.jpg",
				"./Portrait/Concert/Eric/6.jpg",
				"./Portrait/Concert/Family/4.jpg",
				"./Portrait/Concert/Family/5.jpg",
				"./Portrait/Eric/11.jpg",
				"./Portrait/Eric/6.jpg",
				"./Portrait/Eric/Concert/6.jpg",
				"./Portrait/Eric/Festival/11.jpg",
				"./Portrait/Family/10.jpg",
				"./Portrait/Family/4.jpg",
				"./Portrait/Family/5.jpg",
				"./Portrait/Family/Concert/4.jpg",
				"./Portrait/Family/Concert/5.jpg",
				"./Portrait/Family/Festival/10.jpg",
				"./Portrait/Festival/10.jpg",
				"./Portrait/Festival/11.jpg",
				"./Portrait/Festival/Eric/11.jpg",
				"./Portrait/Festival/Family/10.jpg",
				"./Water/7.jpg",
			},
			new String[] {
				".",
				"./.jpg",
				"./.Trash",
				"./Architecture",
				"./jpg",
				"./Competition",
				"./Concert",
				"./Concert/Architecture",
				"./Concert/jpg",
				"./Concert/Eric",
				"./Concert/Family",
				"./Concert/Portrait",
				"./Concert/Portrait/Eric",
				"./Concert/Portrait/Family",
				"./Concert/Water",
				"./Eric",
				"./Eric/Concert",
				"./Eric/Festival",
				"./Family",
				"./Family/Concert",
				"./Family/Festival",
				"./Festival",
				"./Festival/Competition",
				"./Festival/Eric",
				"./Festival/Family",
				"./Festival/Portrait",
				"./Festival/Portrait/Eric",
				"./Festival/Portrait/Family",
				"./Portrait",
				"./Portrait/Concert",
				"./Portrait/Concert/Eric",
				"./Portrait/Concert/Family",
				"./Portrait/Eric",
				"./Portrait/Eric/Concert",
				"./Portrait/Eric/Festival",
				"./Portrait/Family",
				"./Portrait/Family/Concert",
				"./Portrait/Family/Festival",
				"./Portrait/Festival",
				"./Portrait/Festival/Eric",
				"./Portrait/Festival/Family",
				"./Water",
			}
		);
		try {
			fs.rename("/Concert/1.jpg", "/1.jpg");
		} catch (FuseException e) {
			log += e;
			error = true;
			return;
		}
		expect(fs,
			new String[] {
				"./.Trash/1.jpg",
				"./.Trash/old.jpg",
				"./.Trash/old2.jpg",
				"./.jpg/10.jpg",
				"./.jpg/11.jpg",
				"./.jpg/2.jpg",
				"./.jpg/3.jpg",
				"./.jpg/4.jpg",
				"./.jpg/5.jpg",
				"./.jpg/6.jpg",
				"./.jpg/7.jpg",
				"./.jpg/8.jpg",
				"./.jpg/9.jpg",
				"./Architecture/8.jpg",
				"./jpg/2.jpg",
				"./jpg/3.jpg",
				"./Competition/9.jpg",
				"./Concert/2.jpg",
				"./Concert/3.jpg",
				"./Concert/4.jpg",
				"./Concert/5.jpg",
				"./Concert/6.jpg",
				"./Concert/7.jpg",
				"./Concert/8.jpg",
				"./Concert/Architecture/8.jpg",
				"./Concert/jpg/2.jpg",
				"./Concert/jpg/3.jpg",
				"./Concert/Eric/6.jpg",
				"./Concert/Family/4.jpg",
				"./Concert/Family/5.jpg",
				"./Concert/Portrait/4.jpg",
				"./Concert/Portrait/5.jpg",
				"./Concert/Portrait/6.jpg",
				"./Concert/Portrait/Eric/6.jpg",
				"./Concert/Portrait/Family/4.jpg",
				"./Concert/Portrait/Family/5.jpg",
				"./Concert/Water/7.jpg",
				"./Eric/11.jpg",
				"./Eric/6.jpg",
				"./Eric/Concert/6.jpg",
				"./Eric/Festival/11.jpg",
				"./Family/10.jpg",
				"./Family/4.jpg",
				"./Family/5.jpg",
				"./Family/Concert/4.jpg",
				"./Family/Concert/5.jpg",
				"./Family/Festival/10.jpg",
				"./Festival/10.jpg",
				"./Festival/11.jpg",
				"./Festival/9.jpg",
				"./Festival/Competition/9.jpg",
				"./Festival/Eric/11.jpg",
				"./Festival/Family/10.jpg",
				"./Festival/Portrait/10.jpg",
				"./Festival/Portrait/11.jpg",
				"./Festival/Portrait/Eric/11.jpg",
				"./Festival/Portrait/Family/10.jpg",
				"./Portrait/10.jpg",
				"./Portrait/11.jpg",
				"./Portrait/4.jpg",
				"./Portrait/5.jpg",
				"./Portrait/6.jpg",
				"./Portrait/Concert/4.jpg",
				"./Portrait/Concert/5.jpg",
				"./Portrait/Concert/6.jpg",
				"./Portrait/Concert/Eric/6.jpg",
				"./Portrait/Concert/Family/4.jpg",
				"./Portrait/Concert/Family/5.jpg",
				"./Portrait/Eric/11.jpg",
				"./Portrait/Eric/6.jpg",
				"./Portrait/Eric/Concert/6.jpg",
				"./Portrait/Eric/Festival/11.jpg",
				"./Portrait/Family/10.jpg",
				"./Portrait/Family/4.jpg",
				"./Portrait/Family/5.jpg",
				"./Portrait/Family/Concert/4.jpg",
				"./Portrait/Family/Concert/5.jpg",
				"./Portrait/Family/Festival/10.jpg",
				"./Portrait/Festival/10.jpg",
				"./Portrait/Festival/11.jpg",
				"./Portrait/Festival/Eric/11.jpg",
				"./Portrait/Festival/Family/10.jpg",
				"./Water/7.jpg",
			},
			new String[] {
				".",
				"./.jpg",
				"./.Trash",
				"./Architecture",
				"./jpg",
				"./Competition",
				"./Concert",
				"./Concert/Architecture",
				"./Concert/jpg",
				"./Concert/Eric",
				"./Concert/Family",
				"./Concert/Portrait",
				"./Concert/Portrait/Eric",
				"./Concert/Portrait/Family",
				"./Concert/Water",
				"./Eric",
				"./Eric/Concert",
				"./Eric/Festival",
				"./Family",
				"./Family/Concert",
				"./Family/Festival",
				"./Festival",
				"./Festival/Competition",
				"./Festival/Eric",
				"./Festival/Family",
				"./Festival/Portrait",
				"./Festival/Portrait/Eric",
				"./Festival/Portrait/Family",
				"./Portrait",
				"./Portrait/Concert",
				"./Portrait/Concert/Eric",
				"./Portrait/Concert/Family",
				"./Portrait/Eric",
				"./Portrait/Eric/Concert",
				"./Portrait/Eric/Festival",
				"./Portrait/Family",
				"./Portrait/Family/Concert",
				"./Portrait/Family/Festival",
				"./Portrait/Festival",
				"./Portrait/Festival/Eric",
				"./Portrait/Festival/Family",
				"./Water",
			}
		);
	}
}
