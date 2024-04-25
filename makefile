build:
	javac chipmunk/*.java

clean:
	find . |grep '[.]class' |xargs rm -f
	rm -f chip8.tgz

tar: clean
	cd .. && tar cf chip8.tar chipmunk
	gzip ../chip8.tar
	mv ../chip8.tar.gz chip8.tgz

sloc:
	scc chipmunk
