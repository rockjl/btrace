BUILDDIR=../build
SRCDIR=../src
OUTDIR=${BUILDDIR}/windows
CC=gcc

# FIXME: 64 bit option

all:
	${JAVA_HOME}/bin/javac -h ${OUTDIR} ${SRCDIR}/share/classes/com\sun\btrace\BTraceRuntime.java
	mkdir -p ${OUTDIR}
	${CC} -c -I${JAVA_HOME}/include -I${JAVA_HOME}/include/solaris -I${OUTDIR} -o ${OUTDIR}/btrace.o ${SRCDIR}/solaris/native/btrace.c
	/usr/sbin/dtrace -G -o ${OUTDIR}/btraced.o -s ${SRCDIR}/solaris/native/btraced.d ${OUTDIR}/btrace.o
	${CC} -G ${OUTDIR}/btrace.o ${OUTDIR}/btraced.o -o ${OUTDIR}/libbtrace.so

clean:
	rm -rf ${OUTDIR}
