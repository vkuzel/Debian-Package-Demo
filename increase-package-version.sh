#!/usr/bin/env bash
set -e

baseDir=$(dirname "$0")

pushd ${baseDir}/package

export DEBFULLNAME="Some Name"
export DEBEMAIL="some.name@email.com"

# Add new version record to changelog.
dch -Ui "New version"
# Mark latest version as released.
dch -r ""

popd

