#!/bin/sh

# To run e.g. effect 1 do ./run.sh 1

if [ -n "$1" ]
then
	EFFECT="$1"
else
	EFFECT=1
fi

java -cp .:res:lib/jars/lwjgl.jar:lib/jars/lwjgl_util.jar:lib/jars/slick-util.jar:lib/jars/PNGDecoder.jar:src: -Djava.library.path=lib/natives/  calendar/Effect$EFFECT
