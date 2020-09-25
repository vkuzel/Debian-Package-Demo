#!/usr/bin/env bash
set -e

baseDir=$(dirname "$0")

pushd ${baseDir}/repository

# Move generated package files to repository directory.
mv ../debian-package-demo* .

# Generate repository index file.
dpkg-scanpackages -m . /dev/null > Packages

popd

