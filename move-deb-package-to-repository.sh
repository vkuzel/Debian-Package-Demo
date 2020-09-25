#!/usr/bin/env bash
set -e

baseDir=$(dirname "$0")

pushd ${baseDir}

# Move generated packages to repository directory.
mv debian-package-demo* repository/

# Generate repository index file.
cd ${baseDir}/repository
dpkg-scanpackages -m . /dev/null > Packages

popd

