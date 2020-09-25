#!/usr/bin/env bash
set -e

baseDir=$(dirname "$0")

pushd ${baseDir}/package

debuild -us -uc

popd


