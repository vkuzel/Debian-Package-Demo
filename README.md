# Debian Package Demo

Supporting demo application for the article [Upgrade Debian package from included systemd service](https://vkuzel.com/upgrade-debian-package-from-included-systemd-service) which describes how to upgrade the package from within a systemd service installed by the package itself.

The project contains several handy scripts:

* `1-increase-package-version.sh` to release a new version in the `debian/changelog` file.
* `2-create-deb-package.sh` to generate Debian package files.
* `3-move-deb-package-to-repository.sh` to copy generated files into the `repository` directory and to generate APT repository index.
* `4-add-repository-to-apt-sources-list.sh` to add the repository to APT sources list as a trusted file repository.
