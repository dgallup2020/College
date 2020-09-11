
# create a file that is 1MB of zero's
# don't seem to need to do this first though, so leave it out for now
#dd if=/dev/zero of=cs471disk.img count=1024 bs=1024

# build the file system and put into the .img file
/sbin/mke2fs -t ext2 -b 1024 -d /u1/h0/jkinne/public_html/cs471-f2018/HW -E offset=0,no_copy_xattrs -L cs471disk cs471disk.img 20m >> buildImage.log

