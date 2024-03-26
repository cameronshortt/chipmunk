build:
	javac chipmunk/*.java

clean:
	rm -rf chipmunk/*.class basicgraphics/*.class *log chip8.tgz

tar: clean
	cd .. && tar cf chip8.tar chipmunk
	gzip ../chip8.tar
	mv ../chip8.tar.gz chip8.tgz

sloc:
	cloc chipmunk --by-file
