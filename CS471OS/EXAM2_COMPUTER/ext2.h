// note: from Geoff Exoo's CS 471
#ifndef __EXT2__

#define __EXT2__

#define KILO   1024

#define BLOCKADDR(X,BLOCKSIZE)  (1024 + BLOCKSIZE*(X-1))

typedef struct __attribute__((packed)) {
    unsigned int        s_inodes_count;
    unsigned int        s_blocks_count;
    unsigned int        s_r_blocks_count;
    unsigned int        s_free_blocks_count;
    unsigned int        s_free_inodes_count;
    unsigned int        s_first_data_block;
    unsigned int        s_log_block_size;
    unsigned int        s_log_frag_size;
    unsigned int        s_blocks_per_group;
    unsigned int        s_frags_per_group;
    unsigned int        s_inodes_per_group;
    unsigned int        s_mtime;
    unsigned int        s_wtime;
    unsigned short      s_mnt_count;
    unsigned short      s_max_mnt_count;
    unsigned short      s_magic;
    unsigned short      s_state;
    unsigned short      s_errors;
    unsigned short      s_minor_rev_level;
    unsigned int        s_lastcheck;
    unsigned int        s_checkinterval;
    unsigned int        s_creator_os;
    unsigned int        s_rev_level;
    unsigned short      s_def_resuid;
    unsigned short      s_def_resgid;
    unsigned int        s_first_ino;
    unsigned short      s_inode_size;
    unsigned short      s_block_group_nr;
    unsigned int        s_feature_compat;
    unsigned int        s_feature_incompat;
    unsigned int        s_feature_ro_compat;
    char      s_uuid[16];
    char      s_volume_name[16];
    char      s_last_mounted[64];
} SUPERBLOCK;

typedef struct __attribute__((packed)) {
    unsigned int     bg_block_bitmap;
    unsigned int     bg_inode_bitmap;
    unsigned int     bg_inode_table;
    unsigned short   bg_free_blocks_count;
    unsigned short   bg_free_inodes_count;
    unsigned short   bg_used_dirs_count;
    unsigned short   bg_pad;
    char             bg_reserved[12];
} BLOCKGROUP;

typedef struct __attribute__((packed)) {
   unsigned short       i_mode;
   unsigned short       i_uid;
   unsigned int         i_size;
   unsigned int         i_atime;
   unsigned int         i_ctime;
   unsigned int         i_mtime;
   unsigned int         i_dtime;
   unsigned short       i_gid;
   unsigned short       i_links_count;
   unsigned int         i_blocks;
   unsigned int         i_flags;
   unsigned int         i_osd1;
   unsigned int         i_block[15];
   unsigned int         i_generation;
   unsigned int         i_file_acl;
   unsigned int         i_dir_acl;
   unsigned int         i_faddr;
   char                 i_osd2[12];
} INODE;

typedef struct __attribute__((packed)) {
   unsigned int inode;
   unsigned short rec_len;
   unsigned char name_len;
   unsigned char file_type;
} DIRHDR;

typedef struct ext2filestructure {
  int fd;
  int blocksize;
  int blocksleft;
  int bytesleft;
  int blockno;
  SUPERBLOCK sb;
  BLOCKGROUP bg;
} EXT2FILE;

EXT2FILE ext2list[1];

#define ITBLOCK   (ext2list[0].bg.bg_inode_table)
#define INOSIZE   (ext2list[0].sb.s_inode_size)
#define BLOCKSIZE (ext2list[0].blocksize)

int indir[]={
  0,0,0,0,0,
  0,0,0,0,0,
  0,0,1,2,3
};

#endif
