
_fault:     file format elf32-i386


Disassembly of section .text:

00000000 <main>:
#include "stat.h"
#include "user.h"

int
main(int argc, char *argv[])
{
   0:	8d 4c 24 04          	lea    0x4(%esp),%ecx
   4:	83 e4 f0             	and    $0xfffffff0,%esp
   7:	ff 71 fc             	pushl  -0x4(%ecx)
   a:	55                   	push   %ebp
   b:	89 e5                	mov    %esp,%ebp
   d:	53                   	push   %ebx
   e:	51                   	push   %ecx
  // standard checking of argc and usage statement
  if (argc < 2) {
   f:	83 39 01             	cmpl   $0x1,(%ecx)
{
  12:	8b 41 04             	mov    0x4(%ecx),%eax
  if (argc < 2) {
  15:	7e 3f                	jle    56 <main+0x56>
    printf(1, " 1 - seg fault\n");
    printf(2, " 2 - divide by 0\n");
    exit();
  }
  // standard grabbing command line argumen ts
  int which = atoi(argv[1]);
  17:	83 ec 0c             	sub    $0xc,%esp
  1a:	ff 70 04             	pushl  0x4(%eax)
  1d:	e8 6e 02 00 00       	call   290 <atoi>
  // used below
  int zero = 0;
  int * bad_p =(int *) 0x80000000; 

  // so I can see on the screen how far we got
  printf(1,"Faulting, based on argument...\n");
  22:	59                   	pop    %ecx
  int which = atoi(argv[1]);
  23:	89 c3                	mov    %eax,%ebx
  printf(1,"Faulting, based on argument...\n");
  25:	58                   	pop    %eax
  26:	68 38 08 00 00       	push   $0x838
  2b:	6a 01                	push   $0x1
  2d:	e8 4e 04 00 00       	call   480 <printf>

  if (which == 0)
  32:	83 c4 10             	add    $0x10,%esp
  35:	85 db                	test   %ebx,%ebx
  37:	74 0a                	je     43 <main+0x43>
    ;
  else if (which == 1) {
  39:	83 fb 01             	cmp    $0x1,%ebx
  3c:	74 55                	je     93 <main+0x93>
    which = *bad_p; // supposed to be bad memory access, because in xv6, kernel code starts at virtual memory address bad_p
    printf(1, "which = %d", which); // shouldn't see this print out
  }
  else if (which == 2) { 
  3e:	83 fb 02             	cmp    $0x2,%ebx
  41:	74 68                	je     ab <main+0xab>
  }

  // note: there are other problems we could try to make happen

  // if there was a fault, shouldn't see this either
  printf(1,"Note - got here without dying...\n");
  43:	50                   	push   %eax
  44:	50                   	push   %eax
  45:	68 58 08 00 00       	push   $0x858
  4a:	6a 01                	push   $0x1
  4c:	e8 2f 04 00 00       	call   480 <printf>
  
  exit();
  51:	e8 ab 02 00 00       	call   301 <exit>
    printf(1, "Usage: ./fault type\n");
  56:	50                   	push   %eax
  57:	50                   	push   %eax
  58:	68 e8 07 00 00       	push   $0x7e8
  5d:	6a 01                	push   $0x1
  5f:	e8 1c 04 00 00       	call   480 <printf>
    printf(1, " 0 - none\n");
  64:	58                   	pop    %eax
  65:	5a                   	pop    %edx
  66:	68 fd 07 00 00       	push   $0x7fd
  6b:	6a 01                	push   $0x1
  6d:	e8 0e 04 00 00       	call   480 <printf>
    printf(1, " 1 - seg fault\n");
  72:	59                   	pop    %ecx
  73:	5b                   	pop    %ebx
  74:	68 08 08 00 00       	push   $0x808
  79:	6a 01                	push   $0x1
  7b:	e8 00 04 00 00       	call   480 <printf>
    printf(2, " 2 - divide by 0\n");
  80:	58                   	pop    %eax
  81:	5a                   	pop    %edx
  82:	68 18 08 00 00       	push   $0x818
  87:	6a 02                	push   $0x2
  89:	e8 f2 03 00 00       	call   480 <printf>
    exit();
  8e:	e8 6e 02 00 00       	call   301 <exit>
    printf(1, "which = %d", which); // shouldn't see this print out
  93:	52                   	push   %edx
  94:	ff 35 00 00 00 80    	pushl  0x80000000
  9a:	68 2a 08 00 00       	push   $0x82a
  9f:	6a 01                	push   $0x1
  a1:	e8 da 03 00 00       	call   480 <printf>
  a6:	83 c4 10             	add    $0x10,%esp
  a9:	eb 98                	jmp    43 <main+0x43>
    which = which / zero; // had which / 0, but the compiler caught that
  ab:	0f 0b                	ud2    
  ad:	66 90                	xchg   %ax,%ax
  af:	90                   	nop

000000b0 <strcpy>:
#include "user.h"
#include "x86.h"

char*
strcpy(char *s, char *t)
{
  b0:	55                   	push   %ebp
  char *os;

  os = s;
  while((*s++ = *t++) != 0)
  b1:	31 d2                	xor    %edx,%edx
{
  b3:	89 e5                	mov    %esp,%ebp
  b5:	53                   	push   %ebx
  b6:	8b 45 08             	mov    0x8(%ebp),%eax
  b9:	8b 5d 0c             	mov    0xc(%ebp),%ebx
  bc:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
  while((*s++ = *t++) != 0)
  c0:	0f b6 0c 13          	movzbl (%ebx,%edx,1),%ecx
  c4:	88 0c 10             	mov    %cl,(%eax,%edx,1)
  c7:	83 c2 01             	add    $0x1,%edx
  ca:	84 c9                	test   %cl,%cl
  cc:	75 f2                	jne    c0 <strcpy+0x10>
    ;
  return os;
}
  ce:	5b                   	pop    %ebx
  cf:	5d                   	pop    %ebp
  d0:	c3                   	ret    
  d1:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
  d8:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
  df:	90                   	nop

000000e0 <strcmp>:

int
strcmp(const char *p, const char *q)
{
  e0:	55                   	push   %ebp
  e1:	89 e5                	mov    %esp,%ebp
  e3:	56                   	push   %esi
  e4:	53                   	push   %ebx
  e5:	8b 5d 08             	mov    0x8(%ebp),%ebx
  e8:	8b 75 0c             	mov    0xc(%ebp),%esi
  while(*p && *p == *q)
  eb:	0f b6 13             	movzbl (%ebx),%edx
  ee:	0f b6 0e             	movzbl (%esi),%ecx
  f1:	84 d2                	test   %dl,%dl
  f3:	74 1e                	je     113 <strcmp+0x33>
  f5:	b8 01 00 00 00       	mov    $0x1,%eax
  fa:	38 ca                	cmp    %cl,%dl
  fc:	74 09                	je     107 <strcmp+0x27>
  fe:	eb 20                	jmp    120 <strcmp+0x40>
 100:	83 c0 01             	add    $0x1,%eax
 103:	38 ca                	cmp    %cl,%dl
 105:	75 19                	jne    120 <strcmp+0x40>
 107:	0f b6 14 03          	movzbl (%ebx,%eax,1),%edx
 10b:	0f b6 0c 06          	movzbl (%esi,%eax,1),%ecx
 10f:	84 d2                	test   %dl,%dl
 111:	75 ed                	jne    100 <strcmp+0x20>
 113:	31 c0                	xor    %eax,%eax
    p++, q++;
  return (uchar)*p - (uchar)*q;
}
 115:	5b                   	pop    %ebx
 116:	5e                   	pop    %esi
  return (uchar)*p - (uchar)*q;
 117:	29 c8                	sub    %ecx,%eax
}
 119:	5d                   	pop    %ebp
 11a:	c3                   	ret    
 11b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 11f:	90                   	nop
 120:	0f b6 c2             	movzbl %dl,%eax
 123:	5b                   	pop    %ebx
 124:	5e                   	pop    %esi
  return (uchar)*p - (uchar)*q;
 125:	29 c8                	sub    %ecx,%eax
}
 127:	5d                   	pop    %ebp
 128:	c3                   	ret    
 129:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi

00000130 <strlen>:

uint
strlen(char *s)
{
 130:	55                   	push   %ebp
 131:	89 e5                	mov    %esp,%ebp
 133:	8b 4d 08             	mov    0x8(%ebp),%ecx
  int n;

  for(n = 0; s[n]; n++)
 136:	80 39 00             	cmpb   $0x0,(%ecx)
 139:	74 15                	je     150 <strlen+0x20>
 13b:	31 d2                	xor    %edx,%edx
 13d:	8d 76 00             	lea    0x0(%esi),%esi
 140:	83 c2 01             	add    $0x1,%edx
 143:	80 3c 11 00          	cmpb   $0x0,(%ecx,%edx,1)
 147:	89 d0                	mov    %edx,%eax
 149:	75 f5                	jne    140 <strlen+0x10>
    ;
  return n;
}
 14b:	5d                   	pop    %ebp
 14c:	c3                   	ret    
 14d:	8d 76 00             	lea    0x0(%esi),%esi
  for(n = 0; s[n]; n++)
 150:	31 c0                	xor    %eax,%eax
}
 152:	5d                   	pop    %ebp
 153:	c3                   	ret    
 154:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 15b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 15f:	90                   	nop

00000160 <memset>:

void*
memset(void *dst, int c, uint n)
{
 160:	55                   	push   %ebp
 161:	89 e5                	mov    %esp,%ebp
 163:	57                   	push   %edi
 164:	8b 55 08             	mov    0x8(%ebp),%edx
}

static inline void
stosb(void *addr, int data, int cnt)
{
  asm volatile("cld; rep stosb" :
 167:	8b 4d 10             	mov    0x10(%ebp),%ecx
 16a:	8b 45 0c             	mov    0xc(%ebp),%eax
 16d:	89 d7                	mov    %edx,%edi
 16f:	fc                   	cld    
 170:	f3 aa                	rep stos %al,%es:(%edi)
  stosb(dst, c, n);
  return dst;
}
 172:	89 d0                	mov    %edx,%eax
 174:	5f                   	pop    %edi
 175:	5d                   	pop    %ebp
 176:	c3                   	ret    
 177:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 17e:	66 90                	xchg   %ax,%ax

00000180 <strchr>:

char*
strchr(const char *s, char c)
{
 180:	55                   	push   %ebp
 181:	89 e5                	mov    %esp,%ebp
 183:	53                   	push   %ebx
 184:	8b 45 08             	mov    0x8(%ebp),%eax
 187:	8b 55 0c             	mov    0xc(%ebp),%edx
  for(; *s; s++)
 18a:	0f b6 18             	movzbl (%eax),%ebx
 18d:	84 db                	test   %bl,%bl
 18f:	74 1d                	je     1ae <strchr+0x2e>
 191:	89 d1                	mov    %edx,%ecx
    if(*s == c)
 193:	38 d3                	cmp    %dl,%bl
 195:	75 0d                	jne    1a4 <strchr+0x24>
 197:	eb 17                	jmp    1b0 <strchr+0x30>
 199:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 1a0:	38 ca                	cmp    %cl,%dl
 1a2:	74 0c                	je     1b0 <strchr+0x30>
  for(; *s; s++)
 1a4:	83 c0 01             	add    $0x1,%eax
 1a7:	0f b6 10             	movzbl (%eax),%edx
 1aa:	84 d2                	test   %dl,%dl
 1ac:	75 f2                	jne    1a0 <strchr+0x20>
      return (char*)s;
  return 0;
 1ae:	31 c0                	xor    %eax,%eax
}
 1b0:	5b                   	pop    %ebx
 1b1:	5d                   	pop    %ebp
 1b2:	c3                   	ret    
 1b3:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 1ba:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi

000001c0 <gets>:

char*
gets(char *buf, int max)
{
 1c0:	55                   	push   %ebp
 1c1:	89 e5                	mov    %esp,%ebp
 1c3:	57                   	push   %edi
 1c4:	56                   	push   %esi
  int i, cc;
  char c;

  for(i=0; i+1 < max; ){
 1c5:	31 f6                	xor    %esi,%esi
{
 1c7:	53                   	push   %ebx
 1c8:	89 f3                	mov    %esi,%ebx
 1ca:	83 ec 1c             	sub    $0x1c,%esp
 1cd:	8b 7d 08             	mov    0x8(%ebp),%edi
  for(i=0; i+1 < max; ){
 1d0:	eb 2f                	jmp    201 <gets+0x41>
 1d2:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi
    cc = read(0, &c, 1);
 1d8:	83 ec 04             	sub    $0x4,%esp
 1db:	8d 45 e7             	lea    -0x19(%ebp),%eax
 1de:	6a 01                	push   $0x1
 1e0:	50                   	push   %eax
 1e1:	6a 00                	push   $0x0
 1e3:	e8 31 01 00 00       	call   319 <read>
    if(cc < 1)
 1e8:	83 c4 10             	add    $0x10,%esp
 1eb:	85 c0                	test   %eax,%eax
 1ed:	7e 1c                	jle    20b <gets+0x4b>
      break;
    buf[i++] = c;
 1ef:	0f b6 45 e7          	movzbl -0x19(%ebp),%eax
 1f3:	83 c7 01             	add    $0x1,%edi
 1f6:	88 47 ff             	mov    %al,-0x1(%edi)
    if(c == '\n' || c == '\r')
 1f9:	3c 0a                	cmp    $0xa,%al
 1fb:	74 23                	je     220 <gets+0x60>
 1fd:	3c 0d                	cmp    $0xd,%al
 1ff:	74 1f                	je     220 <gets+0x60>
  for(i=0; i+1 < max; ){
 201:	83 c3 01             	add    $0x1,%ebx
 204:	89 fe                	mov    %edi,%esi
 206:	3b 5d 0c             	cmp    0xc(%ebp),%ebx
 209:	7c cd                	jl     1d8 <gets+0x18>
 20b:	89 f3                	mov    %esi,%ebx
      break;
  }
  buf[i] = '\0';
  return buf;
}
 20d:	8b 45 08             	mov    0x8(%ebp),%eax
  buf[i] = '\0';
 210:	c6 03 00             	movb   $0x0,(%ebx)
}
 213:	8d 65 f4             	lea    -0xc(%ebp),%esp
 216:	5b                   	pop    %ebx
 217:	5e                   	pop    %esi
 218:	5f                   	pop    %edi
 219:	5d                   	pop    %ebp
 21a:	c3                   	ret    
 21b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 21f:	90                   	nop
 220:	8b 75 08             	mov    0x8(%ebp),%esi
 223:	8b 45 08             	mov    0x8(%ebp),%eax
 226:	01 de                	add    %ebx,%esi
 228:	89 f3                	mov    %esi,%ebx
  buf[i] = '\0';
 22a:	c6 03 00             	movb   $0x0,(%ebx)
}
 22d:	8d 65 f4             	lea    -0xc(%ebp),%esp
 230:	5b                   	pop    %ebx
 231:	5e                   	pop    %esi
 232:	5f                   	pop    %edi
 233:	5d                   	pop    %ebp
 234:	c3                   	ret    
 235:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 23c:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi

00000240 <stat>:

int
stat(char *n, struct stat *st)
{
 240:	55                   	push   %ebp
 241:	89 e5                	mov    %esp,%ebp
 243:	56                   	push   %esi
 244:	53                   	push   %ebx
  int fd;
  int r;

  fd = open(n, O_RDONLY);
 245:	83 ec 08             	sub    $0x8,%esp
 248:	6a 00                	push   $0x0
 24a:	ff 75 08             	pushl  0x8(%ebp)
 24d:	e8 ef 00 00 00       	call   341 <open>
  if(fd < 0)
 252:	83 c4 10             	add    $0x10,%esp
 255:	85 c0                	test   %eax,%eax
 257:	78 27                	js     280 <stat+0x40>
    return -1;
  r = fstat(fd, st);
 259:	83 ec 08             	sub    $0x8,%esp
 25c:	ff 75 0c             	pushl  0xc(%ebp)
 25f:	89 c3                	mov    %eax,%ebx
 261:	50                   	push   %eax
 262:	e8 f2 00 00 00       	call   359 <fstat>
  close(fd);
 267:	89 1c 24             	mov    %ebx,(%esp)
  r = fstat(fd, st);
 26a:	89 c6                	mov    %eax,%esi
  close(fd);
 26c:	e8 b8 00 00 00       	call   329 <close>
  return r;
 271:	83 c4 10             	add    $0x10,%esp
}
 274:	8d 65 f8             	lea    -0x8(%ebp),%esp
 277:	89 f0                	mov    %esi,%eax
 279:	5b                   	pop    %ebx
 27a:	5e                   	pop    %esi
 27b:	5d                   	pop    %ebp
 27c:	c3                   	ret    
 27d:	8d 76 00             	lea    0x0(%esi),%esi
    return -1;
 280:	be ff ff ff ff       	mov    $0xffffffff,%esi
 285:	eb ed                	jmp    274 <stat+0x34>
 287:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 28e:	66 90                	xchg   %ax,%ax

00000290 <atoi>:

int
atoi(const char *s)
{
 290:	55                   	push   %ebp
 291:	89 e5                	mov    %esp,%ebp
 293:	53                   	push   %ebx
 294:	8b 4d 08             	mov    0x8(%ebp),%ecx
  int n;

  n = 0;
  while('0' <= *s && *s <= '9')
 297:	0f be 11             	movsbl (%ecx),%edx
 29a:	8d 42 d0             	lea    -0x30(%edx),%eax
 29d:	3c 09                	cmp    $0x9,%al
  n = 0;
 29f:	b8 00 00 00 00       	mov    $0x0,%eax
  while('0' <= *s && *s <= '9')
 2a4:	77 1f                	ja     2c5 <atoi+0x35>
 2a6:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 2ad:	8d 76 00             	lea    0x0(%esi),%esi
    n = n*10 + *s++ - '0';
 2b0:	83 c1 01             	add    $0x1,%ecx
 2b3:	8d 04 80             	lea    (%eax,%eax,4),%eax
 2b6:	8d 44 42 d0          	lea    -0x30(%edx,%eax,2),%eax
  while('0' <= *s && *s <= '9')
 2ba:	0f be 11             	movsbl (%ecx),%edx
 2bd:	8d 5a d0             	lea    -0x30(%edx),%ebx
 2c0:	80 fb 09             	cmp    $0x9,%bl
 2c3:	76 eb                	jbe    2b0 <atoi+0x20>
  return n;
}
 2c5:	5b                   	pop    %ebx
 2c6:	5d                   	pop    %ebp
 2c7:	c3                   	ret    
 2c8:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 2cf:	90                   	nop

000002d0 <memmove>:

void*
memmove(void *vdst, void *vsrc, int n)
{
 2d0:	55                   	push   %ebp
 2d1:	89 e5                	mov    %esp,%ebp
 2d3:	57                   	push   %edi
 2d4:	8b 55 10             	mov    0x10(%ebp),%edx
 2d7:	8b 45 08             	mov    0x8(%ebp),%eax
 2da:	56                   	push   %esi
 2db:	8b 75 0c             	mov    0xc(%ebp),%esi
  char *dst, *src;

  dst = vdst;
  src = vsrc;
  while(n-- > 0)
 2de:	85 d2                	test   %edx,%edx
 2e0:	7e 13                	jle    2f5 <memmove+0x25>
 2e2:	01 c2                	add    %eax,%edx
  dst = vdst;
 2e4:	89 c7                	mov    %eax,%edi
 2e6:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 2ed:	8d 76 00             	lea    0x0(%esi),%esi
    *dst++ = *src++;
 2f0:	a4                   	movsb  %ds:(%esi),%es:(%edi)
  while(n-- > 0)
 2f1:	39 fa                	cmp    %edi,%edx
 2f3:	75 fb                	jne    2f0 <memmove+0x20>
  return vdst;
}
 2f5:	5e                   	pop    %esi
 2f6:	5f                   	pop    %edi
 2f7:	5d                   	pop    %ebp
 2f8:	c3                   	ret    

000002f9 <fork>:
  name: \
    movl $SYS_ ## name, %eax; \
    int $T_SYSCALL; \
    ret

SYSCALL(fork)
 2f9:	b8 01 00 00 00       	mov    $0x1,%eax
 2fe:	cd 40                	int    $0x40
 300:	c3                   	ret    

00000301 <exit>:
SYSCALL(exit)
 301:	b8 02 00 00 00       	mov    $0x2,%eax
 306:	cd 40                	int    $0x40
 308:	c3                   	ret    

00000309 <wait>:
SYSCALL(wait)
 309:	b8 03 00 00 00       	mov    $0x3,%eax
 30e:	cd 40                	int    $0x40
 310:	c3                   	ret    

00000311 <pipe>:
SYSCALL(pipe)
 311:	b8 04 00 00 00       	mov    $0x4,%eax
 316:	cd 40                	int    $0x40
 318:	c3                   	ret    

00000319 <read>:
SYSCALL(read)
 319:	b8 05 00 00 00       	mov    $0x5,%eax
 31e:	cd 40                	int    $0x40
 320:	c3                   	ret    

00000321 <write>:
SYSCALL(write)
 321:	b8 10 00 00 00       	mov    $0x10,%eax
 326:	cd 40                	int    $0x40
 328:	c3                   	ret    

00000329 <close>:
SYSCALL(close)
 329:	b8 15 00 00 00       	mov    $0x15,%eax
 32e:	cd 40                	int    $0x40
 330:	c3                   	ret    

00000331 <kill>:
SYSCALL(kill)
 331:	b8 06 00 00 00       	mov    $0x6,%eax
 336:	cd 40                	int    $0x40
 338:	c3                   	ret    

00000339 <exec>:
SYSCALL(exec)
 339:	b8 07 00 00 00       	mov    $0x7,%eax
 33e:	cd 40                	int    $0x40
 340:	c3                   	ret    

00000341 <open>:
SYSCALL(open)
 341:	b8 0f 00 00 00       	mov    $0xf,%eax
 346:	cd 40                	int    $0x40
 348:	c3                   	ret    

00000349 <mknod>:
SYSCALL(mknod)
 349:	b8 11 00 00 00       	mov    $0x11,%eax
 34e:	cd 40                	int    $0x40
 350:	c3                   	ret    

00000351 <unlink>:
SYSCALL(unlink)
 351:	b8 12 00 00 00       	mov    $0x12,%eax
 356:	cd 40                	int    $0x40
 358:	c3                   	ret    

00000359 <fstat>:
SYSCALL(fstat)
 359:	b8 08 00 00 00       	mov    $0x8,%eax
 35e:	cd 40                	int    $0x40
 360:	c3                   	ret    

00000361 <link>:
SYSCALL(link)
 361:	b8 13 00 00 00       	mov    $0x13,%eax
 366:	cd 40                	int    $0x40
 368:	c3                   	ret    

00000369 <mkdir>:
SYSCALL(mkdir)
 369:	b8 14 00 00 00       	mov    $0x14,%eax
 36e:	cd 40                	int    $0x40
 370:	c3                   	ret    

00000371 <chdir>:
SYSCALL(chdir)
 371:	b8 09 00 00 00       	mov    $0x9,%eax
 376:	cd 40                	int    $0x40
 378:	c3                   	ret    

00000379 <dup>:
SYSCALL(dup)
 379:	b8 0a 00 00 00       	mov    $0xa,%eax
 37e:	cd 40                	int    $0x40
 380:	c3                   	ret    

00000381 <getpid>:
SYSCALL(getpid)
 381:	b8 0b 00 00 00       	mov    $0xb,%eax
 386:	cd 40                	int    $0x40
 388:	c3                   	ret    

00000389 <sbrk>:
SYSCALL(sbrk)
 389:	b8 0c 00 00 00       	mov    $0xc,%eax
 38e:	cd 40                	int    $0x40
 390:	c3                   	ret    

00000391 <sleep>:
SYSCALL(sleep)
 391:	b8 0d 00 00 00       	mov    $0xd,%eax
 396:	cd 40                	int    $0x40
 398:	c3                   	ret    

00000399 <uptime>:
SYSCALL(uptime)
 399:	b8 0e 00 00 00       	mov    $0xe,%eax
 39e:	cd 40                	int    $0x40
 3a0:	c3                   	ret    

000003a1 <usage>:
SYSCALL(usage)
 3a1:	b8 16 00 00 00       	mov    $0x16,%eax
 3a6:	cd 40                	int    $0x40
 3a8:	c3                   	ret    

000003a9 <ticks>:
 3a9:	b8 17 00 00 00       	mov    $0x17,%eax
 3ae:	cd 40                	int    $0x40
 3b0:	c3                   	ret    
 3b1:	66 90                	xchg   %ax,%ax
 3b3:	66 90                	xchg   %ax,%ax
 3b5:	66 90                	xchg   %ax,%ax
 3b7:	66 90                	xchg   %ax,%ax
 3b9:	66 90                	xchg   %ax,%ax
 3bb:	66 90                	xchg   %ax,%ax
 3bd:	66 90                	xchg   %ax,%ax
 3bf:	90                   	nop

000003c0 <printint>:
  write(fd, &c, 1);
}

static void
printint(int fd, int xx, int base, int sgn)
{
 3c0:	55                   	push   %ebp
 3c1:	89 e5                	mov    %esp,%ebp
 3c3:	57                   	push   %edi
 3c4:	56                   	push   %esi
 3c5:	53                   	push   %ebx
  uint x;

  neg = 0;
  if(sgn && xx < 0){
    neg = 1;
    x = -xx;
 3c6:	89 d3                	mov    %edx,%ebx
{
 3c8:	83 ec 3c             	sub    $0x3c,%esp
 3cb:	89 45 bc             	mov    %eax,-0x44(%ebp)
  if(sgn && xx < 0){
 3ce:	85 d2                	test   %edx,%edx
 3d0:	0f 89 92 00 00 00    	jns    468 <printint+0xa8>
 3d6:	f6 45 08 01          	testb  $0x1,0x8(%ebp)
 3da:	0f 84 88 00 00 00    	je     468 <printint+0xa8>
    neg = 1;
 3e0:	c7 45 c0 01 00 00 00 	movl   $0x1,-0x40(%ebp)
    x = -xx;
 3e7:	f7 db                	neg    %ebx
  } else {
    x = xx;
  }

  i = 0;
 3e9:	c7 45 c4 00 00 00 00 	movl   $0x0,-0x3c(%ebp)
 3f0:	8d 75 d7             	lea    -0x29(%ebp),%esi
 3f3:	eb 08                	jmp    3fd <printint+0x3d>
 3f5:	8d 76 00             	lea    0x0(%esi),%esi
  do{
    buf[i++] = digits[x % base];
 3f8:	89 7d c4             	mov    %edi,-0x3c(%ebp)
  }while((x /= base) != 0);
 3fb:	89 c3                	mov    %eax,%ebx
    buf[i++] = digits[x % base];
 3fd:	89 d8                	mov    %ebx,%eax
 3ff:	31 d2                	xor    %edx,%edx
 401:	8b 7d c4             	mov    -0x3c(%ebp),%edi
 404:	f7 f1                	div    %ecx
 406:	83 c7 01             	add    $0x1,%edi
 409:	0f b6 92 84 08 00 00 	movzbl 0x884(%edx),%edx
 410:	88 14 3e             	mov    %dl,(%esi,%edi,1)
  }while((x /= base) != 0);
 413:	39 d9                	cmp    %ebx,%ecx
 415:	76 e1                	jbe    3f8 <printint+0x38>
  if(neg)
 417:	8b 45 c0             	mov    -0x40(%ebp),%eax
 41a:	85 c0                	test   %eax,%eax
 41c:	74 0d                	je     42b <printint+0x6b>
    buf[i++] = '-';
 41e:	c6 44 3d d8 2d       	movb   $0x2d,-0x28(%ebp,%edi,1)
 423:	ba 2d 00 00 00       	mov    $0x2d,%edx
    buf[i++] = digits[x % base];
 428:	89 7d c4             	mov    %edi,-0x3c(%ebp)
 42b:	8b 45 c4             	mov    -0x3c(%ebp),%eax
 42e:	8b 7d bc             	mov    -0x44(%ebp),%edi
 431:	8d 5c 05 d7          	lea    -0x29(%ebp,%eax,1),%ebx
 435:	eb 0f                	jmp    446 <printint+0x86>
 437:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 43e:	66 90                	xchg   %ax,%ax
 440:	0f b6 13             	movzbl (%ebx),%edx
 443:	83 eb 01             	sub    $0x1,%ebx
  write(fd, &c, 1);
 446:	83 ec 04             	sub    $0x4,%esp
 449:	88 55 d7             	mov    %dl,-0x29(%ebp)
 44c:	6a 01                	push   $0x1
 44e:	56                   	push   %esi
 44f:	57                   	push   %edi
 450:	e8 cc fe ff ff       	call   321 <write>

  while(--i >= 0)
 455:	83 c4 10             	add    $0x10,%esp
 458:	39 de                	cmp    %ebx,%esi
 45a:	75 e4                	jne    440 <printint+0x80>
    putc(fd, buf[i]);
}
 45c:	8d 65 f4             	lea    -0xc(%ebp),%esp
 45f:	5b                   	pop    %ebx
 460:	5e                   	pop    %esi
 461:	5f                   	pop    %edi
 462:	5d                   	pop    %ebp
 463:	c3                   	ret    
 464:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
  neg = 0;
 468:	c7 45 c0 00 00 00 00 	movl   $0x0,-0x40(%ebp)
 46f:	e9 75 ff ff ff       	jmp    3e9 <printint+0x29>
 474:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 47b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 47f:	90                   	nop

00000480 <printf>:

// Print to the given fd. Only understands %d, %x, %p, %s.
void
printf(int fd, char *fmt, ...)
{
 480:	55                   	push   %ebp
 481:	89 e5                	mov    %esp,%ebp
 483:	57                   	push   %edi
 484:	56                   	push   %esi
 485:	53                   	push   %ebx
 486:	83 ec 2c             	sub    $0x2c,%esp
  int c, i, state;
  uint *ap;

  state = 0;
  ap = (uint*)(void*)&fmt + 1;
  for(i = 0; fmt[i]; i++){
 489:	8b 75 0c             	mov    0xc(%ebp),%esi
 48c:	0f b6 1e             	movzbl (%esi),%ebx
 48f:	84 db                	test   %bl,%bl
 491:	0f 84 b9 00 00 00    	je     550 <printf+0xd0>
  ap = (uint*)(void*)&fmt + 1;
 497:	8d 45 10             	lea    0x10(%ebp),%eax
 49a:	83 c6 01             	add    $0x1,%esi
  write(fd, &c, 1);
 49d:	8d 7d e7             	lea    -0x19(%ebp),%edi
  state = 0;
 4a0:	31 d2                	xor    %edx,%edx
  ap = (uint*)(void*)&fmt + 1;
 4a2:	89 45 d0             	mov    %eax,-0x30(%ebp)
 4a5:	eb 38                	jmp    4df <printf+0x5f>
 4a7:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 4ae:	66 90                	xchg   %ax,%ax
 4b0:	89 55 d4             	mov    %edx,-0x2c(%ebp)
    c = fmt[i] & 0xff;
    if(state == 0){
      if(c == '%'){
        state = '%';
 4b3:	ba 25 00 00 00       	mov    $0x25,%edx
      if(c == '%'){
 4b8:	83 f8 25             	cmp    $0x25,%eax
 4bb:	74 17                	je     4d4 <printf+0x54>
  write(fd, &c, 1);
 4bd:	83 ec 04             	sub    $0x4,%esp
 4c0:	88 5d e7             	mov    %bl,-0x19(%ebp)
 4c3:	6a 01                	push   $0x1
 4c5:	57                   	push   %edi
 4c6:	ff 75 08             	pushl  0x8(%ebp)
 4c9:	e8 53 fe ff ff       	call   321 <write>
 4ce:	8b 55 d4             	mov    -0x2c(%ebp),%edx
      } else {
        putc(fd, c);
 4d1:	83 c4 10             	add    $0x10,%esp
 4d4:	83 c6 01             	add    $0x1,%esi
  for(i = 0; fmt[i]; i++){
 4d7:	0f b6 5e ff          	movzbl -0x1(%esi),%ebx
 4db:	84 db                	test   %bl,%bl
 4dd:	74 71                	je     550 <printf+0xd0>
    c = fmt[i] & 0xff;
 4df:	0f be cb             	movsbl %bl,%ecx
 4e2:	0f b6 c3             	movzbl %bl,%eax
    if(state == 0){
 4e5:	85 d2                	test   %edx,%edx
 4e7:	74 c7                	je     4b0 <printf+0x30>
      }
    } else if(state == '%'){
 4e9:	83 fa 25             	cmp    $0x25,%edx
 4ec:	75 e6                	jne    4d4 <printf+0x54>
      if(c == 'd'){
 4ee:	83 f8 64             	cmp    $0x64,%eax
 4f1:	0f 84 99 00 00 00    	je     590 <printf+0x110>
        printint(fd, *ap, 10, 1);
        ap++;
      } else if(c == 'x' || c == 'p'){
 4f7:	81 e1 f7 00 00 00    	and    $0xf7,%ecx
 4fd:	83 f9 70             	cmp    $0x70,%ecx
 500:	74 5e                	je     560 <printf+0xe0>
        printint(fd, *ap, 16, 0);
        ap++;
      } else if(c == 's'){
 502:	83 f8 73             	cmp    $0x73,%eax
 505:	0f 84 d5 00 00 00    	je     5e0 <printf+0x160>
          s = "(null)";
        while(*s != 0){
          putc(fd, *s);
          s++;
        }
      } else if(c == 'c'){
 50b:	83 f8 63             	cmp    $0x63,%eax
 50e:	0f 84 8c 00 00 00    	je     5a0 <printf+0x120>
        putc(fd, *ap);
        ap++;
      } else if(c == '%'){
 514:	83 f8 25             	cmp    $0x25,%eax
 517:	0f 84 b3 00 00 00    	je     5d0 <printf+0x150>
  write(fd, &c, 1);
 51d:	83 ec 04             	sub    $0x4,%esp
 520:	c6 45 e7 25          	movb   $0x25,-0x19(%ebp)
 524:	6a 01                	push   $0x1
 526:	57                   	push   %edi
 527:	ff 75 08             	pushl  0x8(%ebp)
 52a:	e8 f2 fd ff ff       	call   321 <write>
        putc(fd, c);
      } else {
        // Unknown % sequence.  Print it to draw attention.
        putc(fd, '%');
        putc(fd, c);
 52f:	88 5d e7             	mov    %bl,-0x19(%ebp)
  write(fd, &c, 1);
 532:	83 c4 0c             	add    $0xc,%esp
 535:	6a 01                	push   $0x1
 537:	83 c6 01             	add    $0x1,%esi
 53a:	57                   	push   %edi
 53b:	ff 75 08             	pushl  0x8(%ebp)
 53e:	e8 de fd ff ff       	call   321 <write>
  for(i = 0; fmt[i]; i++){
 543:	0f b6 5e ff          	movzbl -0x1(%esi),%ebx
        putc(fd, c);
 547:	83 c4 10             	add    $0x10,%esp
      }
      state = 0;
 54a:	31 d2                	xor    %edx,%edx
  for(i = 0; fmt[i]; i++){
 54c:	84 db                	test   %bl,%bl
 54e:	75 8f                	jne    4df <printf+0x5f>
    }
  }
}
 550:	8d 65 f4             	lea    -0xc(%ebp),%esp
 553:	5b                   	pop    %ebx
 554:	5e                   	pop    %esi
 555:	5f                   	pop    %edi
 556:	5d                   	pop    %ebp
 557:	c3                   	ret    
 558:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 55f:	90                   	nop
        printint(fd, *ap, 16, 0);
 560:	83 ec 0c             	sub    $0xc,%esp
 563:	b9 10 00 00 00       	mov    $0x10,%ecx
 568:	6a 00                	push   $0x0
 56a:	8b 5d d0             	mov    -0x30(%ebp),%ebx
 56d:	8b 45 08             	mov    0x8(%ebp),%eax
 570:	8b 13                	mov    (%ebx),%edx
 572:	e8 49 fe ff ff       	call   3c0 <printint>
        ap++;
 577:	89 d8                	mov    %ebx,%eax
 579:	83 c4 10             	add    $0x10,%esp
      state = 0;
 57c:	31 d2                	xor    %edx,%edx
        ap++;
 57e:	83 c0 04             	add    $0x4,%eax
 581:	89 45 d0             	mov    %eax,-0x30(%ebp)
 584:	e9 4b ff ff ff       	jmp    4d4 <printf+0x54>
 589:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
        printint(fd, *ap, 10, 1);
 590:	83 ec 0c             	sub    $0xc,%esp
 593:	b9 0a 00 00 00       	mov    $0xa,%ecx
 598:	6a 01                	push   $0x1
 59a:	eb ce                	jmp    56a <printf+0xea>
 59c:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
        putc(fd, *ap);
 5a0:	8b 5d d0             	mov    -0x30(%ebp),%ebx
  write(fd, &c, 1);
 5a3:	83 ec 04             	sub    $0x4,%esp
        putc(fd, *ap);
 5a6:	8b 03                	mov    (%ebx),%eax
  write(fd, &c, 1);
 5a8:	6a 01                	push   $0x1
        ap++;
 5aa:	83 c3 04             	add    $0x4,%ebx
  write(fd, &c, 1);
 5ad:	57                   	push   %edi
 5ae:	ff 75 08             	pushl  0x8(%ebp)
        putc(fd, *ap);
 5b1:	88 45 e7             	mov    %al,-0x19(%ebp)
  write(fd, &c, 1);
 5b4:	e8 68 fd ff ff       	call   321 <write>
        ap++;
 5b9:	89 5d d0             	mov    %ebx,-0x30(%ebp)
 5bc:	83 c4 10             	add    $0x10,%esp
      state = 0;
 5bf:	31 d2                	xor    %edx,%edx
 5c1:	e9 0e ff ff ff       	jmp    4d4 <printf+0x54>
 5c6:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 5cd:	8d 76 00             	lea    0x0(%esi),%esi
        putc(fd, c);
 5d0:	88 5d e7             	mov    %bl,-0x19(%ebp)
  write(fd, &c, 1);
 5d3:	83 ec 04             	sub    $0x4,%esp
 5d6:	e9 5a ff ff ff       	jmp    535 <printf+0xb5>
 5db:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 5df:	90                   	nop
        s = (char*)*ap;
 5e0:	8b 45 d0             	mov    -0x30(%ebp),%eax
 5e3:	8b 18                	mov    (%eax),%ebx
        ap++;
 5e5:	83 c0 04             	add    $0x4,%eax
 5e8:	89 45 d0             	mov    %eax,-0x30(%ebp)
        if(s == 0)
 5eb:	85 db                	test   %ebx,%ebx
 5ed:	74 17                	je     606 <printf+0x186>
        while(*s != 0){
 5ef:	0f b6 03             	movzbl (%ebx),%eax
      state = 0;
 5f2:	31 d2                	xor    %edx,%edx
        while(*s != 0){
 5f4:	84 c0                	test   %al,%al
 5f6:	0f 84 d8 fe ff ff    	je     4d4 <printf+0x54>
 5fc:	89 75 d4             	mov    %esi,-0x2c(%ebp)
 5ff:	89 de                	mov    %ebx,%esi
 601:	8b 5d 08             	mov    0x8(%ebp),%ebx
 604:	eb 1a                	jmp    620 <printf+0x1a0>
          s = "(null)";
 606:	bb 7c 08 00 00       	mov    $0x87c,%ebx
        while(*s != 0){
 60b:	89 75 d4             	mov    %esi,-0x2c(%ebp)
 60e:	b8 28 00 00 00       	mov    $0x28,%eax
 613:	89 de                	mov    %ebx,%esi
 615:	8b 5d 08             	mov    0x8(%ebp),%ebx
 618:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 61f:	90                   	nop
  write(fd, &c, 1);
 620:	83 ec 04             	sub    $0x4,%esp
          s++;
 623:	83 c6 01             	add    $0x1,%esi
 626:	88 45 e7             	mov    %al,-0x19(%ebp)
  write(fd, &c, 1);
 629:	6a 01                	push   $0x1
 62b:	57                   	push   %edi
 62c:	53                   	push   %ebx
 62d:	e8 ef fc ff ff       	call   321 <write>
        while(*s != 0){
 632:	0f b6 06             	movzbl (%esi),%eax
 635:	83 c4 10             	add    $0x10,%esp
 638:	84 c0                	test   %al,%al
 63a:	75 e4                	jne    620 <printf+0x1a0>
 63c:	8b 75 d4             	mov    -0x2c(%ebp),%esi
      state = 0;
 63f:	31 d2                	xor    %edx,%edx
 641:	e9 8e fe ff ff       	jmp    4d4 <printf+0x54>
 646:	66 90                	xchg   %ax,%ax
 648:	66 90                	xchg   %ax,%ax
 64a:	66 90                	xchg   %ax,%ax
 64c:	66 90                	xchg   %ax,%ax
 64e:	66 90                	xchg   %ax,%ax

00000650 <free>:
static Header base;
static Header *freep;

void
free(void *ap)
{
 650:	55                   	push   %ebp
  Header *bp, *p;

  bp = (Header*)ap - 1;
  for(p = freep; !(bp > p && bp < p->s.ptr); p = p->s.ptr)
 651:	a1 30 0b 00 00       	mov    0xb30,%eax
{
 656:	89 e5                	mov    %esp,%ebp
 658:	57                   	push   %edi
 659:	56                   	push   %esi
 65a:	53                   	push   %ebx
 65b:	8b 5d 08             	mov    0x8(%ebp),%ebx
 65e:	8b 10                	mov    (%eax),%edx
  bp = (Header*)ap - 1;
 660:	8d 4b f8             	lea    -0x8(%ebx),%ecx
  for(p = freep; !(bp > p && bp < p->s.ptr); p = p->s.ptr)
 663:	39 c8                	cmp    %ecx,%eax
 665:	73 19                	jae    680 <free+0x30>
 667:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 66e:	66 90                	xchg   %ax,%ax
 670:	39 d1                	cmp    %edx,%ecx
 672:	72 14                	jb     688 <free+0x38>
    if(p >= p->s.ptr && (bp > p || bp < p->s.ptr))
 674:	39 d0                	cmp    %edx,%eax
 676:	73 10                	jae    688 <free+0x38>
{
 678:	89 d0                	mov    %edx,%eax
 67a:	8b 10                	mov    (%eax),%edx
  for(p = freep; !(bp > p && bp < p->s.ptr); p = p->s.ptr)
 67c:	39 c8                	cmp    %ecx,%eax
 67e:	72 f0                	jb     670 <free+0x20>
    if(p >= p->s.ptr && (bp > p || bp < p->s.ptr))
 680:	39 d0                	cmp    %edx,%eax
 682:	72 f4                	jb     678 <free+0x28>
 684:	39 d1                	cmp    %edx,%ecx
 686:	73 f0                	jae    678 <free+0x28>
      break;
  if(bp + bp->s.size == p->s.ptr){
 688:	8b 73 fc             	mov    -0x4(%ebx),%esi
 68b:	8d 3c f1             	lea    (%ecx,%esi,8),%edi
 68e:	39 fa                	cmp    %edi,%edx
 690:	74 1e                	je     6b0 <free+0x60>
    bp->s.size += p->s.ptr->s.size;
    bp->s.ptr = p->s.ptr->s.ptr;
  } else
    bp->s.ptr = p->s.ptr;
 692:	89 53 f8             	mov    %edx,-0x8(%ebx)
  if(p + p->s.size == bp){
 695:	8b 50 04             	mov    0x4(%eax),%edx
 698:	8d 34 d0             	lea    (%eax,%edx,8),%esi
 69b:	39 f1                	cmp    %esi,%ecx
 69d:	74 28                	je     6c7 <free+0x77>
    p->s.size += bp->s.size;
    p->s.ptr = bp->s.ptr;
  } else
    p->s.ptr = bp;
 69f:	89 08                	mov    %ecx,(%eax)
  freep = p;
}
 6a1:	5b                   	pop    %ebx
  freep = p;
 6a2:	a3 30 0b 00 00       	mov    %eax,0xb30
}
 6a7:	5e                   	pop    %esi
 6a8:	5f                   	pop    %edi
 6a9:	5d                   	pop    %ebp
 6aa:	c3                   	ret    
 6ab:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 6af:	90                   	nop
    bp->s.size += p->s.ptr->s.size;
 6b0:	03 72 04             	add    0x4(%edx),%esi
 6b3:	89 73 fc             	mov    %esi,-0x4(%ebx)
    bp->s.ptr = p->s.ptr->s.ptr;
 6b6:	8b 10                	mov    (%eax),%edx
 6b8:	8b 12                	mov    (%edx),%edx
 6ba:	89 53 f8             	mov    %edx,-0x8(%ebx)
  if(p + p->s.size == bp){
 6bd:	8b 50 04             	mov    0x4(%eax),%edx
 6c0:	8d 34 d0             	lea    (%eax,%edx,8),%esi
 6c3:	39 f1                	cmp    %esi,%ecx
 6c5:	75 d8                	jne    69f <free+0x4f>
    p->s.size += bp->s.size;
 6c7:	03 53 fc             	add    -0x4(%ebx),%edx
  freep = p;
 6ca:	a3 30 0b 00 00       	mov    %eax,0xb30
    p->s.size += bp->s.size;
 6cf:	89 50 04             	mov    %edx,0x4(%eax)
    p->s.ptr = bp->s.ptr;
 6d2:	8b 53 f8             	mov    -0x8(%ebx),%edx
 6d5:	89 10                	mov    %edx,(%eax)
}
 6d7:	5b                   	pop    %ebx
 6d8:	5e                   	pop    %esi
 6d9:	5f                   	pop    %edi
 6da:	5d                   	pop    %ebp
 6db:	c3                   	ret    
 6dc:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi

000006e0 <malloc>:
  return freep;
}

void*
malloc(uint nbytes)
{
 6e0:	55                   	push   %ebp
 6e1:	89 e5                	mov    %esp,%ebp
 6e3:	57                   	push   %edi
 6e4:	56                   	push   %esi
 6e5:	53                   	push   %ebx
 6e6:	83 ec 1c             	sub    $0x1c,%esp
  Header *p, *prevp;
  uint nunits;

  nunits = (nbytes + sizeof(Header) - 1)/sizeof(Header) + 1;
 6e9:	8b 45 08             	mov    0x8(%ebp),%eax
  if((prevp = freep) == 0){
 6ec:	8b 3d 30 0b 00 00    	mov    0xb30,%edi
  nunits = (nbytes + sizeof(Header) - 1)/sizeof(Header) + 1;
 6f2:	8d 70 07             	lea    0x7(%eax),%esi
 6f5:	c1 ee 03             	shr    $0x3,%esi
 6f8:	83 c6 01             	add    $0x1,%esi
  if((prevp = freep) == 0){
 6fb:	85 ff                	test   %edi,%edi
 6fd:	0f 84 ad 00 00 00    	je     7b0 <malloc+0xd0>
    base.s.ptr = freep = prevp = &base;
    base.s.size = 0;
  }
  for(p = prevp->s.ptr; ; prevp = p, p = p->s.ptr){
 703:	8b 17                	mov    (%edi),%edx
    if(p->s.size >= nunits){
 705:	8b 4a 04             	mov    0x4(%edx),%ecx
 708:	39 ce                	cmp    %ecx,%esi
 70a:	76 72                	jbe    77e <malloc+0x9e>
 70c:	81 fe 00 10 00 00    	cmp    $0x1000,%esi
 712:	bb 00 10 00 00       	mov    $0x1000,%ebx
 717:	0f 43 de             	cmovae %esi,%ebx
  p = sbrk(nu * sizeof(Header));
 71a:	8d 04 dd 00 00 00 00 	lea    0x0(,%ebx,8),%eax
 721:	89 45 e4             	mov    %eax,-0x1c(%ebp)
 724:	eb 1b                	jmp    741 <malloc+0x61>
 726:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 72d:	8d 76 00             	lea    0x0(%esi),%esi
  for(p = prevp->s.ptr; ; prevp = p, p = p->s.ptr){
 730:	8b 02                	mov    (%edx),%eax
    if(p->s.size >= nunits){
 732:	8b 48 04             	mov    0x4(%eax),%ecx
 735:	39 f1                	cmp    %esi,%ecx
 737:	73 4f                	jae    788 <malloc+0xa8>
 739:	8b 3d 30 0b 00 00    	mov    0xb30,%edi
 73f:	89 c2                	mov    %eax,%edx
        p->s.size = nunits;
      }
      freep = prevp;
      return (void*)(p + 1);
    }
    if(p == freep)
 741:	39 d7                	cmp    %edx,%edi
 743:	75 eb                	jne    730 <malloc+0x50>
  p = sbrk(nu * sizeof(Header));
 745:	83 ec 0c             	sub    $0xc,%esp
 748:	ff 75 e4             	pushl  -0x1c(%ebp)
 74b:	e8 39 fc ff ff       	call   389 <sbrk>
  if(p == (char*)-1)
 750:	83 c4 10             	add    $0x10,%esp
 753:	83 f8 ff             	cmp    $0xffffffff,%eax
 756:	74 1c                	je     774 <malloc+0x94>
  hp->s.size = nu;
 758:	89 58 04             	mov    %ebx,0x4(%eax)
  free((void*)(hp + 1));
 75b:	83 ec 0c             	sub    $0xc,%esp
 75e:	83 c0 08             	add    $0x8,%eax
 761:	50                   	push   %eax
 762:	e8 e9 fe ff ff       	call   650 <free>
  return freep;
 767:	8b 15 30 0b 00 00    	mov    0xb30,%edx
      if((p = morecore(nunits)) == 0)
 76d:	83 c4 10             	add    $0x10,%esp
 770:	85 d2                	test   %edx,%edx
 772:	75 bc                	jne    730 <malloc+0x50>
        return 0;
  }
}
 774:	8d 65 f4             	lea    -0xc(%ebp),%esp
        return 0;
 777:	31 c0                	xor    %eax,%eax
}
 779:	5b                   	pop    %ebx
 77a:	5e                   	pop    %esi
 77b:	5f                   	pop    %edi
 77c:	5d                   	pop    %ebp
 77d:	c3                   	ret    
    if(p->s.size >= nunits){
 77e:	89 d0                	mov    %edx,%eax
 780:	89 fa                	mov    %edi,%edx
 782:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi
      if(p->s.size == nunits)
 788:	39 ce                	cmp    %ecx,%esi
 78a:	74 54                	je     7e0 <malloc+0x100>
        p->s.size -= nunits;
 78c:	29 f1                	sub    %esi,%ecx
 78e:	89 48 04             	mov    %ecx,0x4(%eax)
        p += p->s.size;
 791:	8d 04 c8             	lea    (%eax,%ecx,8),%eax
        p->s.size = nunits;
 794:	89 70 04             	mov    %esi,0x4(%eax)
      freep = prevp;
 797:	89 15 30 0b 00 00    	mov    %edx,0xb30
}
 79d:	8d 65 f4             	lea    -0xc(%ebp),%esp
      return (void*)(p + 1);
 7a0:	83 c0 08             	add    $0x8,%eax
}
 7a3:	5b                   	pop    %ebx
 7a4:	5e                   	pop    %esi
 7a5:	5f                   	pop    %edi
 7a6:	5d                   	pop    %ebp
 7a7:	c3                   	ret    
 7a8:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 7af:	90                   	nop
    base.s.ptr = freep = prevp = &base;
 7b0:	c7 05 30 0b 00 00 34 	movl   $0xb34,0xb30
 7b7:	0b 00 00 
    base.s.size = 0;
 7ba:	bf 34 0b 00 00       	mov    $0xb34,%edi
    base.s.ptr = freep = prevp = &base;
 7bf:	c7 05 34 0b 00 00 34 	movl   $0xb34,0xb34
 7c6:	0b 00 00 
  for(p = prevp->s.ptr; ; prevp = p, p = p->s.ptr){
 7c9:	89 fa                	mov    %edi,%edx
    base.s.size = 0;
 7cb:	c7 05 38 0b 00 00 00 	movl   $0x0,0xb38
 7d2:	00 00 00 
    if(p->s.size >= nunits){
 7d5:	e9 32 ff ff ff       	jmp    70c <malloc+0x2c>
 7da:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi
        prevp->s.ptr = p->s.ptr;
 7e0:	8b 08                	mov    (%eax),%ecx
 7e2:	89 0a                	mov    %ecx,(%edx)
 7e4:	eb b1                	jmp    797 <malloc+0xb7>
