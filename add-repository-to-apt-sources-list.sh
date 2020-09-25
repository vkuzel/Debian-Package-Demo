#!/usr/bin/env bash
set -e

baseDir=$(dirname "$0")
sourcesListFile=/etc/apt/sources.list.d/debian-package-demo.list

if [[ -f ${sourcesListFile} ]]; then
	echo "Sources list $sourcesListFile exists!"
else
	sudo echo "deb [trusted=yes] file:///${baseDir}/repository ./" > ${sourcesListFile}
	echo "Sources list added. Don't forget to run `sudo apt update'"
fi

