
_primes:     file format elf32-i386


Disassembly of section .text:

00000000 <main>:
  return 1;
}

int
main(int argc, char *argv[])
{
   0:	8d 4c 24 04          	lea    0x4(%esp),%ecx
   4:	83 e4 f0             	and    $0xfffffff0,%esp
   7:	ff 71 fc             	pushl  -0x4(%ecx)
   a:	55                   	push   %ebp
   b:	89 e5                	mov    %esp,%ebp
   d:	57                   	push   %edi
   e:	56                   	push   %esi
   f:	53                   	push   %ebx
  10:	51                   	push   %ecx
  11:	83 ec 08             	sub    $0x8,%esp
  if(argc < 2){
  14:	83 39 01             	cmpl   $0x1,(%ecx)
{
  17:	8b 41 04             	mov    0x4(%ecx),%eax
  if(argc < 2){
  1a:	0f 8e 7c 00 00 00    	jle    9c <main+0x9c>
    printf(2, "Usage: n\n");
    exit();
  }

  int begin = 2;
  int end = atoi(argv[1]);
  20:	83 ec 0c             	sub    $0xc,%esp
  23:	ff 70 04             	pushl  0x4(%eax)
  26:	e8 d5 02 00 00       	call   300 <atoi>
  int i;
  
  for(i = begin; i <= end; i++) {
  2b:	83 c4 10             	add    $0x10,%esp
  2e:	83 f8 01             	cmp    $0x1,%eax
  31:	7e 64                	jle    97 <main+0x97>
  33:	8d 78 01             	lea    0x1(%eax),%edi
  36:	bb 02 00 00 00       	mov    $0x2,%ebx
    if (n % i == 0) return 0;
  3b:	be ab aa aa aa       	mov    $0xaaaaaaab,%esi
  if (n == 2) return 1;
  40:	83 fb 02             	cmp    $0x2,%ebx
  43:	74 38                	je     7d <main+0x7d>
  if (n % 2 == 0) return 0;
  45:	f6 c3 01             	test   $0x1,%bl
  48:	74 46                	je     90 <main+0x90>
  for(i=3; i*i <= n; i += 2) {
  4a:	83 fb 08             	cmp    $0x8,%ebx
  4d:	7e 2e                	jle    7d <main+0x7d>
    if (n % i == 0) return 0;
  4f:	89 d8                	mov    %ebx,%eax
  51:	f7 e6                	mul    %esi
  53:	d1 ea                	shr    %edx
  55:	8d 04 52             	lea    (%edx,%edx,2),%eax
  58:	39 c3                	cmp    %eax,%ebx
  5a:	74 34                	je     90 <main+0x90>
  for(i=3; i*i <= n; i += 2) {
  5c:	b9 03 00 00 00       	mov    $0x3,%ecx
  61:	eb 0e                	jmp    71 <main+0x71>
  63:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
  67:	90                   	nop
    if (n % i == 0) return 0;
  68:	89 d8                	mov    %ebx,%eax
  6a:	99                   	cltd   
  6b:	f7 f9                	idiv   %ecx
  6d:	85 d2                	test   %edx,%edx
  6f:	74 1f                	je     90 <main+0x90>
  for(i=3; i*i <= n; i += 2) {
  71:	83 c1 02             	add    $0x2,%ecx
  74:	89 c8                	mov    %ecx,%eax
  76:	0f af c1             	imul   %ecx,%eax
  79:	39 d8                	cmp    %ebx,%eax
  7b:	7e eb                	jle    68 <main+0x68>
    if (isPrime(i) == 1) {
      printf(1, "%d\n", i);
  7d:	83 ec 04             	sub    $0x4,%esp
  80:	53                   	push   %ebx
  81:	68 62 08 00 00       	push   $0x862
  86:	6a 01                	push   $0x1
  88:	e8 63 04 00 00       	call   4f0 <printf>
  8d:	83 c4 10             	add    $0x10,%esp
  for(i = begin; i <= end; i++) {
  90:	83 c3 01             	add    $0x1,%ebx
  93:	39 fb                	cmp    %edi,%ebx
  95:	75 a9                	jne    40 <main+0x40>
    }
  }

  exit();
  97:	e8 d5 02 00 00       	call   371 <exit>
    printf(2, "Usage: n\n");
  9c:	50                   	push   %eax
  9d:	50                   	push   %eax
  9e:	68 58 08 00 00       	push   $0x858
  a3:	6a 02                	push   $0x2
  a5:	e8 46 04 00 00       	call   4f0 <printf>
    exit();
  aa:	e8 c2 02 00 00       	call   371 <exit>
  af:	90                   	nop

000000b0 <isPrime>:
int isPrime(int n) {
  b0:	55                   	push   %ebp
  if (n < 2) return 0;
  b1:	31 d2                	xor    %edx,%edx
int isPrime(int n) {
  b3:	89 e5                	mov    %esp,%ebp
  b5:	53                   	push   %ebx
  b6:	8b 5d 08             	mov    0x8(%ebp),%ebx
  if (n < 2) return 0;
  b9:	83 fb 01             	cmp    $0x1,%ebx
  bc:	7e 54                	jle    112 <isPrime+0x62>
  if (n == 2) return 1;
  be:	ba 01 00 00 00       	mov    $0x1,%edx
  c3:	83 fb 02             	cmp    $0x2,%ebx
  c6:	74 4a                	je     112 <isPrime+0x62>
  if (n < 2) return 0;
  c8:	31 d2                	xor    %edx,%edx
  if (n % 2 == 0) return 0;
  ca:	f6 c3 01             	test   $0x1,%bl
  cd:	74 43                	je     112 <isPrime+0x62>
  for(i=3; i*i <= n; i += 2) {
  cf:	83 fb 08             	cmp    $0x8,%ebx
  d2:	7e 39                	jle    10d <isPrime+0x5d>
    if (n % i == 0) return 0;
  d4:	89 d8                	mov    %ebx,%eax
  d6:	ba 56 55 55 55       	mov    $0x55555556,%edx
  db:	f7 ea                	imul   %edx
  dd:	89 d8                	mov    %ebx,%eax
  df:	c1 f8 1f             	sar    $0x1f,%eax
  e2:	29 c2                	sub    %eax,%edx
  e4:	8d 04 52             	lea    (%edx,%edx,2),%eax
  e7:	89 da                	mov    %ebx,%edx
  e9:	29 c2                	sub    %eax,%edx
  eb:	74 25                	je     112 <isPrime+0x62>
  for(i=3; i*i <= n; i += 2) {
  ed:	b9 03 00 00 00       	mov    $0x3,%ecx
  f2:	eb 0d                	jmp    101 <isPrime+0x51>
  f4:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
    if (n % i == 0) return 0;
  f8:	89 d8                	mov    %ebx,%eax
  fa:	99                   	cltd   
  fb:	f7 f9                	idiv   %ecx
  fd:	85 d2                	test   %edx,%edx
  ff:	74 11                	je     112 <isPrime+0x62>
  for(i=3; i*i <= n; i += 2) {
 101:	83 c1 02             	add    $0x2,%ecx
 104:	89 c8                	mov    %ecx,%eax
 106:	0f af c1             	imul   %ecx,%eax
 109:	39 c3                	cmp    %eax,%ebx
 10b:	7d eb                	jge    f8 <isPrime+0x48>
  if (n == 2) return 1;
 10d:	ba 01 00 00 00       	mov    $0x1,%edx
}
 112:	89 d0                	mov    %edx,%eax
 114:	5b                   	pop    %ebx
 115:	5d                   	pop    %ebp
 116:	c3                   	ret    
 117:	66 90                	xchg   %ax,%ax
 119:	66 90                	xchg   %ax,%ax
 11b:	66 90                	xchg   %ax,%ax
 11d:	66 90                	xchg   %ax,%ax
 11f:	90                   	nop

00000120 <strcpy>:
#include "user.h"
#include "x86.h"

char*
strcpy(char *s, char *t)
{
 120:	55                   	push   %ebp
  char *os;

  os = s;
  while((*s++ = *t++) != 0)
 121:	31 d2                	xor    %edx,%edx
{
 123:	89 e5                	mov    %esp,%ebp
 125:	53                   	push   %ebx
 126:	8b 45 08             	mov    0x8(%ebp),%eax
 129:	8b 5d 0c             	mov    0xc(%ebp),%ebx
 12c:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
  while((*s++ = *t++) != 0)
 130:	0f b6 0c 13          	movzbl (%ebx,%edx,1),%ecx
 134:	88 0c 10             	mov    %cl,(%eax,%edx,1)
 137:	83 c2 01             	add    $0x1,%edx
 13a:	84 c9                	test   %cl,%cl
 13c:	75 f2                	jne    130 <strcpy+0x10>
    ;
  return os;
}
 13e:	5b                   	pop    %ebx
 13f:	5d                   	pop    %ebp
 140:	c3                   	ret    
 141:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 148:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 14f:	90                   	nop

00000150 <strcmp>:

int
strcmp(const char *p, const char *q)
{
 150:	55                   	push   %ebp
 151:	89 e5                	mov    %esp,%ebp
 153:	56                   	push   %esi
 154:	53                   	push   %ebx
 155:	8b 5d 08             	mov    0x8(%ebp),%ebx
 158:	8b 75 0c             	mov    0xc(%ebp),%esi
  while(*p && *p == *q)
 15b:	0f b6 13             	movzbl (%ebx),%edx
 15e:	0f b6 0e             	movzbl (%esi),%ecx
 161:	84 d2                	test   %dl,%dl
 163:	74 1e                	je     183 <strcmp+0x33>
 165:	b8 01 00 00 00       	mov    $0x1,%eax
 16a:	38 ca                	cmp    %cl,%dl
 16c:	74 09                	je     177 <strcmp+0x27>
 16e:	eb 20                	jmp    190 <strcmp+0x40>
 170:	83 c0 01             	add    $0x1,%eax
 173:	38 ca                	cmp    %cl,%dl
 175:	75 19                	jne    190 <strcmp+0x40>
 177:	0f b6 14 03          	movzbl (%ebx,%eax,1),%edx
 17b:	0f b6 0c 06          	movzbl (%esi,%eax,1),%ecx
 17f:	84 d2                	test   %dl,%dl
 181:	75 ed                	jne    170 <strcmp+0x20>
 183:	31 c0                	xor    %eax,%eax
    p++, q++;
  return (uchar)*p - (uchar)*q;
}
 185:	5b                   	pop    %ebx
 186:	5e                   	pop    %esi
  return (uchar)*p - (uchar)*q;
 187:	29 c8                	sub    %ecx,%eax
}
 189:	5d                   	pop    %ebp
 18a:	c3                   	ret    
 18b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 18f:	90                   	nop
 190:	0f b6 c2             	movzbl %dl,%eax
 193:	5b                   	pop    %ebx
 194:	5e                   	pop    %esi
  return (uchar)*p - (uchar)*q;
 195:	29 c8                	sub    %ecx,%eax
}
 197:	5d                   	pop    %ebp
 198:	c3                   	ret    
 199:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi

000001a0 <strlen>:

uint
strlen(char *s)
{
 1a0:	55                   	push   %ebp
 1a1:	89 e5                	mov    %esp,%ebp
 1a3:	8b 4d 08             	mov    0x8(%ebp),%ecx
  int n;

  for(n = 0; s[n]; n++)
 1a6:	80 39 00             	cmpb   $0x0,(%ecx)
 1a9:	74 15                	je     1c0 <strlen+0x20>
 1ab:	31 d2                	xor    %edx,%edx
 1ad:	8d 76 00             	lea    0x0(%esi),%esi
 1b0:	83 c2 01             	add    $0x1,%edx
 1b3:	80 3c 11 00          	cmpb   $0x0,(%ecx,%edx,1)
 1b7:	89 d0                	mov    %edx,%eax
 1b9:	75 f5                	jne    1b0 <strlen+0x10>
    ;
  return n;
}
 1bb:	5d                   	pop    %ebp
 1bc:	c3                   	ret    
 1bd:	8d 76 00             	lea    0x0(%esi),%esi
  for(n = 0; s[n]; n++)
 1c0:	31 c0                	xor    %eax,%eax
}
 1c2:	5d                   	pop    %ebp
 1c3:	c3                   	ret    
 1c4:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 1cb:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 1cf:	90                   	nop

000001d0 <memset>:

void*
memset(void *dst, int c, uint n)
{
 1d0:	55                   	push   %ebp
 1d1:	89 e5                	mov    %esp,%ebp
 1d3:	57                   	push   %edi
 1d4:	8b 55 08             	mov    0x8(%ebp),%edx
}

static inline void
stosb(void *addr, int data, int cnt)
{
  asm volatile("cld; rep stosb" :
 1d7:	8b 4d 10             	mov    0x10(%ebp),%ecx
 1da:	8b 45 0c             	mov    0xc(%ebp),%eax
 1dd:	89 d7                	mov    %edx,%edi
 1df:	fc                   	cld    
 1e0:	f3 aa                	rep stos %al,%es:(%edi)
  stosb(dst, c, n);
  return dst;
}
 1e2:	89 d0                	mov    %edx,%eax
 1e4:	5f                   	pop    %edi
 1e5:	5d                   	pop    %ebp
 1e6:	c3                   	ret    
 1e7:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 1ee:	66 90                	xchg   %ax,%ax

000001f0 <strchr>:

char*
strchr(const char *s, char c)
{
 1f0:	55                   	push   %ebp
 1f1:	89 e5                	mov    %esp,%ebp
 1f3:	53                   	push   %ebx
 1f4:	8b 45 08             	mov    0x8(%ebp),%eax
 1f7:	8b 55 0c             	mov    0xc(%ebp),%edx
  for(; *s; s++)
 1fa:	0f b6 18             	movzbl (%eax),%ebx
 1fd:	84 db                	test   %bl,%bl
 1ff:	74 1d                	je     21e <strchr+0x2e>
 201:	89 d1                	mov    %edx,%ecx
    if(*s == c)
 203:	38 d3                	cmp    %dl,%bl
 205:	75 0d                	jne    214 <strchr+0x24>
 207:	eb 17                	jmp    220 <strchr+0x30>
 209:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 210:	38 ca                	cmp    %cl,%dl
 212:	74 0c                	je     220 <strchr+0x30>
  for(; *s; s++)
 214:	83 c0 01             	add    $0x1,%eax
 217:	0f b6 10             	movzbl (%eax),%edx
 21a:	84 d2                	test   %dl,%dl
 21c:	75 f2                	jne    210 <strchr+0x20>
      return (char*)s;
  return 0;
 21e:	31 c0                	xor    %eax,%eax
}
 220:	5b                   	pop    %ebx
 221:	5d                   	pop    %ebp
 222:	c3                   	ret    
 223:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 22a:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi

00000230 <gets>:

char*
gets(char *buf, int max)
{
 230:	55                   	push   %ebp
 231:	89 e5                	mov    %esp,%ebp
 233:	57                   	push   %edi
 234:	56                   	push   %esi
  int i, cc;
  char c;

  for(i=0; i+1 < max; ){
 235:	31 f6                	xor    %esi,%esi
{
 237:	53                   	push   %ebx
 238:	89 f3                	mov    %esi,%ebx
 23a:	83 ec 1c             	sub    $0x1c,%esp
 23d:	8b 7d 08             	mov    0x8(%ebp),%edi
  for(i=0; i+1 < max; ){
 240:	eb 2f                	jmp    271 <gets+0x41>
 242:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi
    cc = read(0, &c, 1);
 248:	83 ec 04             	sub    $0x4,%esp
 24b:	8d 45 e7             	lea    -0x19(%ebp),%eax
 24e:	6a 01                	push   $0x1
 250:	50                   	push   %eax
 251:	6a 00                	push   $0x0
 253:	e8 31 01 00 00       	call   389 <read>
    if(cc < 1)
 258:	83 c4 10             	add    $0x10,%esp
 25b:	85 c0                	test   %eax,%eax
 25d:	7e 1c                	jle    27b <gets+0x4b>
      break;
    buf[i++] = c;
 25f:	0f b6 45 e7          	movzbl -0x19(%ebp),%eax
 263:	83 c7 01             	add    $0x1,%edi
 266:	88 47 ff             	mov    %al,-0x1(%edi)
    if(c == '\n' || c == '\r')
 269:	3c 0a                	cmp    $0xa,%al
 26b:	74 23                	je     290 <gets+0x60>
 26d:	3c 0d                	cmp    $0xd,%al
 26f:	74 1f                	je     290 <gets+0x60>
  for(i=0; i+1 < max; ){
 271:	83 c3 01             	add    $0x1,%ebx
 274:	89 fe                	mov    %edi,%esi
 276:	3b 5d 0c             	cmp    0xc(%ebp),%ebx
 279:	7c cd                	jl     248 <gets+0x18>
 27b:	89 f3                	mov    %esi,%ebx
      break;
  }
  buf[i] = '\0';
  return buf;
}
 27d:	8b 45 08             	mov    0x8(%ebp),%eax
  buf[i] = '\0';
 280:	c6 03 00             	movb   $0x0,(%ebx)
}
 283:	8d 65 f4             	lea    -0xc(%ebp),%esp
 286:	5b                   	pop    %ebx
 287:	5e                   	pop    %esi
 288:	5f                   	pop    %edi
 289:	5d                   	pop    %ebp
 28a:	c3                   	ret    
 28b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 28f:	90                   	nop
 290:	8b 75 08             	mov    0x8(%ebp),%esi
 293:	8b 45 08             	mov    0x8(%ebp),%eax
 296:	01 de                	add    %ebx,%esi
 298:	89 f3                	mov    %esi,%ebx
  buf[i] = '\0';
 29a:	c6 03 00             	movb   $0x0,(%ebx)
}
 29d:	8d 65 f4             	lea    -0xc(%ebp),%esp
 2a0:	5b                   	pop    %ebx
 2a1:	5e                   	pop    %esi
 2a2:	5f                   	pop    %edi
 2a3:	5d                   	pop    %ebp
 2a4:	c3                   	ret    
 2a5:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 2ac:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi

000002b0 <stat>:

int
stat(char *n, struct stat *st)
{
 2b0:	55                   	push   %ebp
 2b1:	89 e5                	mov    %esp,%ebp
 2b3:	56                   	push   %esi
 2b4:	53                   	push   %ebx
  int fd;
  int r;

  fd = open(n, O_RDONLY);
 2b5:	83 ec 08             	sub    $0x8,%esp
 2b8:	6a 00                	push   $0x0
 2ba:	ff 75 08             	pushl  0x8(%ebp)
 2bd:	e8 ef 00 00 00       	call   3b1 <open>
  if(fd < 0)
 2c2:	83 c4 10             	add    $0x10,%esp
 2c5:	85 c0                	test   %eax,%eax
 2c7:	78 27                	js     2f0 <stat+0x40>
    return -1;
  r = fstat(fd, st);
 2c9:	83 ec 08             	sub    $0x8,%esp
 2cc:	ff 75 0c             	pushl  0xc(%ebp)
 2cf:	89 c3                	mov    %eax,%ebx
 2d1:	50                   	push   %eax
 2d2:	e8 f2 00 00 00       	call   3c9 <fstat>
  close(fd);
 2d7:	89 1c 24             	mov    %ebx,(%esp)
  r = fstat(fd, st);
 2da:	89 c6                	mov    %eax,%esi
  close(fd);
 2dc:	e8 b8 00 00 00       	call   399 <close>
  return r;
 2e1:	83 c4 10             	add    $0x10,%esp
}
 2e4:	8d 65 f8             	lea    -0x8(%ebp),%esp
 2e7:	89 f0                	mov    %esi,%eax
 2e9:	5b                   	pop    %ebx
 2ea:	5e                   	pop    %esi
 2eb:	5d                   	pop    %ebp
 2ec:	c3                   	ret    
 2ed:	8d 76 00             	lea    0x0(%esi),%esi
    return -1;
 2f0:	be ff ff ff ff       	mov    $0xffffffff,%esi
 2f5:	eb ed                	jmp    2e4 <stat+0x34>
 2f7:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 2fe:	66 90                	xchg   %ax,%ax

00000300 <atoi>:

int
atoi(const char *s)
{
 300:	55                   	push   %ebp
 301:	89 e5                	mov    %esp,%ebp
 303:	53                   	push   %ebx
 304:	8b 4d 08             	mov    0x8(%ebp),%ecx
  int n;

  n = 0;
  while('0' <= *s && *s <= '9')
 307:	0f be 11             	movsbl (%ecx),%edx
 30a:	8d 42 d0             	lea    -0x30(%edx),%eax
 30d:	3c 09                	cmp    $0x9,%al
  n = 0;
 30f:	b8 00 00 00 00       	mov    $0x0,%eax
  while('0' <= *s && *s <= '9')
 314:	77 1f                	ja     335 <atoi+0x35>
 316:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 31d:	8d 76 00             	lea    0x0(%esi),%esi
    n = n*10 + *s++ - '0';
 320:	83 c1 01             	add    $0x1,%ecx
 323:	8d 04 80             	lea    (%eax,%eax,4),%eax
 326:	8d 44 42 d0          	lea    -0x30(%edx,%eax,2),%eax
  while('0' <= *s && *s <= '9')
 32a:	0f be 11             	movsbl (%ecx),%edx
 32d:	8d 5a d0             	lea    -0x30(%edx),%ebx
 330:	80 fb 09             	cmp    $0x9,%bl
 333:	76 eb                	jbe    320 <atoi+0x20>
  return n;
}
 335:	5b                   	pop    %ebx
 336:	5d                   	pop    %ebp
 337:	c3                   	ret    
 338:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 33f:	90                   	nop

00000340 <memmove>:

void*
memmove(void *vdst, void *vsrc, int n)
{
 340:	55                   	push   %ebp
 341:	89 e5                	mov    %esp,%ebp
 343:	57                   	push   %edi
 344:	8b 55 10             	mov    0x10(%ebp),%edx
 347:	8b 45 08             	mov    0x8(%ebp),%eax
 34a:	56                   	push   %esi
 34b:	8b 75 0c             	mov    0xc(%ebp),%esi
  char *dst, *src;

  dst = vdst;
  src = vsrc;
  while(n-- > 0)
 34e:	85 d2                	test   %edx,%edx
 350:	7e 13                	jle    365 <memmove+0x25>
 352:	01 c2                	add    %eax,%edx
  dst = vdst;
 354:	89 c7                	mov    %eax,%edi
 356:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 35d:	8d 76 00             	lea    0x0(%esi),%esi
    *dst++ = *src++;
 360:	a4                   	movsb  %ds:(%esi),%es:(%edi)
  while(n-- > 0)
 361:	39 fa                	cmp    %edi,%edx
 363:	75 fb                	jne    360 <memmove+0x20>
  return vdst;
}
 365:	5e                   	pop    %esi
 366:	5f                   	pop    %edi
 367:	5d                   	pop    %ebp
 368:	c3                   	ret    

00000369 <fork>:
  name: \
    movl $SYS_ ## name, %eax; \
    int $T_SYSCALL; \
    ret

SYSCALL(fork)
 369:	b8 01 00 00 00       	mov    $0x1,%eax
 36e:	cd 40                	int    $0x40
 370:	c3                   	ret    

00000371 <exit>:
SYSCALL(exit)
 371:	b8 02 00 00 00       	mov    $0x2,%eax
 376:	cd 40                	int    $0x40
 378:	c3                   	ret    

00000379 <wait>:
SYSCALL(wait)
 379:	b8 03 00 00 00       	mov    $0x3,%eax
 37e:	cd 40                	int    $0x40
 380:	c3                   	ret    

00000381 <pipe>:
SYSCALL(pipe)
 381:	b8 04 00 00 00       	mov    $0x4,%eax
 386:	cd 40                	int    $0x40
 388:	c3                   	ret    

00000389 <read>:
SYSCALL(read)
 389:	b8 05 00 00 00       	mov    $0x5,%eax
 38e:	cd 40                	int    $0x40
 390:	c3                   	ret    

00000391 <write>:
SYSCALL(write)
 391:	b8 10 00 00 00       	mov    $0x10,%eax
 396:	cd 40                	int    $0x40
 398:	c3                   	ret    

00000399 <close>:
SYSCALL(close)
 399:	b8 15 00 00 00       	mov    $0x15,%eax
 39e:	cd 40                	int    $0x40
 3a0:	c3                   	ret    

000003a1 <kill>:
SYSCALL(kill)
 3a1:	b8 06 00 00 00       	mov    $0x6,%eax
 3a6:	cd 40                	int    $0x40
 3a8:	c3                   	ret    

000003a9 <exec>:
SYSCALL(exec)
 3a9:	b8 07 00 00 00       	mov    $0x7,%eax
 3ae:	cd 40                	int    $0x40
 3b0:	c3                   	ret    

000003b1 <open>:
SYSCALL(open)
 3b1:	b8 0f 00 00 00       	mov    $0xf,%eax
 3b6:	cd 40                	int    $0x40
 3b8:	c3                   	ret    

000003b9 <mknod>:
SYSCALL(mknod)
 3b9:	b8 11 00 00 00       	mov    $0x11,%eax
 3be:	cd 40                	int    $0x40
 3c0:	c3                   	ret    

000003c1 <unlink>:
SYSCALL(unlink)
 3c1:	b8 12 00 00 00       	mov    $0x12,%eax
 3c6:	cd 40                	int    $0x40
 3c8:	c3                   	ret    

000003c9 <fstat>:
SYSCALL(fstat)
 3c9:	b8 08 00 00 00       	mov    $0x8,%eax
 3ce:	cd 40                	int    $0x40
 3d0:	c3                   	ret    

000003d1 <link>:
SYSCALL(link)
 3d1:	b8 13 00 00 00       	mov    $0x13,%eax
 3d6:	cd 40                	int    $0x40
 3d8:	c3                   	ret    

000003d9 <mkdir>:
SYSCALL(mkdir)
 3d9:	b8 14 00 00 00       	mov    $0x14,%eax
 3de:	cd 40                	int    $0x40
 3e0:	c3                   	ret    

000003e1 <chdir>:
SYSCALL(chdir)
 3e1:	b8 09 00 00 00       	mov    $0x9,%eax
 3e6:	cd 40                	int    $0x40
 3e8:	c3                   	ret    

000003e9 <dup>:
SYSCALL(dup)
 3e9:	b8 0a 00 00 00       	mov    $0xa,%eax
 3ee:	cd 40                	int    $0x40
 3f0:	c3                   	ret    

000003f1 <getpid>:
SYSCALL(getpid)
 3f1:	b8 0b 00 00 00       	mov    $0xb,%eax
 3f6:	cd 40                	int    $0x40
 3f8:	c3                   	ret    

000003f9 <sbrk>:
SYSCALL(sbrk)
 3f9:	b8 0c 00 00 00       	mov    $0xc,%eax
 3fe:	cd 40                	int    $0x40
 400:	c3                   	ret    

00000401 <sleep>:
SYSCALL(sleep)
 401:	b8 0d 00 00 00       	mov    $0xd,%eax
 406:	cd 40                	int    $0x40
 408:	c3                   	ret    

00000409 <uptime>:
SYSCALL(uptime)
 409:	b8 0e 00 00 00       	mov    $0xe,%eax
 40e:	cd 40                	int    $0x40
 410:	c3                   	ret    

00000411 <usage>:
SYSCALL(usage)
 411:	b8 16 00 00 00       	mov    $0x16,%eax
 416:	cd 40                	int    $0x40
 418:	c3                   	ret    

00000419 <ticks>:
 419:	b8 17 00 00 00       	mov    $0x17,%eax
 41e:	cd 40                	int    $0x40
 420:	c3                   	ret    
 421:	66 90                	xchg   %ax,%ax
 423:	66 90                	xchg   %ax,%ax
 425:	66 90                	xchg   %ax,%ax
 427:	66 90                	xchg   %ax,%ax
 429:	66 90                	xchg   %ax,%ax
 42b:	66 90                	xchg   %ax,%ax
 42d:	66 90                	xchg   %ax,%ax
 42f:	90                   	nop

00000430 <printint>:
  write(fd, &c, 1);
}

static void
printint(int fd, int xx, int base, int sgn)
{
 430:	55                   	push   %ebp
 431:	89 e5                	mov    %esp,%ebp
 433:	57                   	push   %edi
 434:	56                   	push   %esi
 435:	53                   	push   %ebx
  uint x;

  neg = 0;
  if(sgn && xx < 0){
    neg = 1;
    x = -xx;
 436:	89 d3                	mov    %edx,%ebx
{
 438:	83 ec 3c             	sub    $0x3c,%esp
 43b:	89 45 bc             	mov    %eax,-0x44(%ebp)
  if(sgn && xx < 0){
 43e:	85 d2                	test   %edx,%edx
 440:	0f 89 92 00 00 00    	jns    4d8 <printint+0xa8>
 446:	f6 45 08 01          	testb  $0x1,0x8(%ebp)
 44a:	0f 84 88 00 00 00    	je     4d8 <printint+0xa8>
    neg = 1;
 450:	c7 45 c0 01 00 00 00 	movl   $0x1,-0x40(%ebp)
    x = -xx;
 457:	f7 db                	neg    %ebx
  } else {
    x = xx;
  }

  i = 0;
 459:	c7 45 c4 00 00 00 00 	movl   $0x0,-0x3c(%ebp)
 460:	8d 75 d7             	lea    -0x29(%ebp),%esi
 463:	eb 08                	jmp    46d <printint+0x3d>
 465:	8d 76 00             	lea    0x0(%esi),%esi
  do{
    buf[i++] = digits[x % base];
 468:	89 7d c4             	mov    %edi,-0x3c(%ebp)
  }while((x /= base) != 0);
 46b:	89 c3                	mov    %eax,%ebx
    buf[i++] = digits[x % base];
 46d:	89 d8                	mov    %ebx,%eax
 46f:	31 d2                	xor    %edx,%edx
 471:	8b 7d c4             	mov    -0x3c(%ebp),%edi
 474:	f7 f1                	div    %ecx
 476:	83 c7 01             	add    $0x1,%edi
 479:	0f b6 92 70 08 00 00 	movzbl 0x870(%edx),%edx
 480:	88 14 3e             	mov    %dl,(%esi,%edi,1)
  }while((x /= base) != 0);
 483:	39 d9                	cmp    %ebx,%ecx
 485:	76 e1                	jbe    468 <printint+0x38>
  if(neg)
 487:	8b 45 c0             	mov    -0x40(%ebp),%eax
 48a:	85 c0                	test   %eax,%eax
 48c:	74 0d                	je     49b <printint+0x6b>
    buf[i++] = '-';
 48e:	c6 44 3d d8 2d       	movb   $0x2d,-0x28(%ebp,%edi,1)
 493:	ba 2d 00 00 00       	mov    $0x2d,%edx
    buf[i++] = digits[x % base];
 498:	89 7d c4             	mov    %edi,-0x3c(%ebp)
 49b:	8b 45 c4             	mov    -0x3c(%ebp),%eax
 49e:	8b 7d bc             	mov    -0x44(%ebp),%edi
 4a1:	8d 5c 05 d7          	lea    -0x29(%ebp,%eax,1),%ebx
 4a5:	eb 0f                	jmp    4b6 <printint+0x86>
 4a7:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 4ae:	66 90                	xchg   %ax,%ax
 4b0:	0f b6 13             	movzbl (%ebx),%edx
 4b3:	83 eb 01             	sub    $0x1,%ebx
  write(fd, &c, 1);
 4b6:	83 ec 04             	sub    $0x4,%esp
 4b9:	88 55 d7             	mov    %dl,-0x29(%ebp)
 4bc:	6a 01                	push   $0x1
 4be:	56                   	push   %esi
 4bf:	57                   	push   %edi
 4c0:	e8 cc fe ff ff       	call   391 <write>

  while(--i >= 0)
 4c5:	83 c4 10             	add    $0x10,%esp
 4c8:	39 de                	cmp    %ebx,%esi
 4ca:	75 e4                	jne    4b0 <printint+0x80>
    putc(fd, buf[i]);
}
 4cc:	8d 65 f4             	lea    -0xc(%ebp),%esp
 4cf:	5b                   	pop    %ebx
 4d0:	5e                   	pop    %esi
 4d1:	5f                   	pop    %edi
 4d2:	5d                   	pop    %ebp
 4d3:	c3                   	ret    
 4d4:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
  neg = 0;
 4d8:	c7 45 c0 00 00 00 00 	movl   $0x0,-0x40(%ebp)
 4df:	e9 75 ff ff ff       	jmp    459 <printint+0x29>
 4e4:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 4eb:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 4ef:	90                   	nop

000004f0 <printf>:

// Print to the given fd. Only understands %d, %x, %p, %s.
void
printf(int fd, char *fmt, ...)
{
 4f0:	55                   	push   %ebp
 4f1:	89 e5                	mov    %esp,%ebp
 4f3:	57                   	push   %edi
 4f4:	56                   	push   %esi
 4f5:	53                   	push   %ebx
 4f6:	83 ec 2c             	sub    $0x2c,%esp
  int c, i, state;
  uint *ap;

  state = 0;
  ap = (uint*)(void*)&fmt + 1;
  for(i = 0; fmt[i]; i++){
 4f9:	8b 75 0c             	mov    0xc(%ebp),%esi
 4fc:	0f b6 1e             	movzbl (%esi),%ebx
 4ff:	84 db                	test   %bl,%bl
 501:	0f 84 b9 00 00 00    	je     5c0 <printf+0xd0>
  ap = (uint*)(void*)&fmt + 1;
 507:	8d 45 10             	lea    0x10(%ebp),%eax
 50a:	83 c6 01             	add    $0x1,%esi
  write(fd, &c, 1);
 50d:	8d 7d e7             	lea    -0x19(%ebp),%edi
  state = 0;
 510:	31 d2                	xor    %edx,%edx
  ap = (uint*)(void*)&fmt + 1;
 512:	89 45 d0             	mov    %eax,-0x30(%ebp)
 515:	eb 38                	jmp    54f <printf+0x5f>
 517:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 51e:	66 90                	xchg   %ax,%ax
 520:	89 55 d4             	mov    %edx,-0x2c(%ebp)
    c = fmt[i] & 0xff;
    if(state == 0){
      if(c == '%'){
        state = '%';
 523:	ba 25 00 00 00       	mov    $0x25,%edx
      if(c == '%'){
 528:	83 f8 25             	cmp    $0x25,%eax
 52b:	74 17                	je     544 <printf+0x54>
  write(fd, &c, 1);
 52d:	83 ec 04             	sub    $0x4,%esp
 530:	88 5d e7             	mov    %bl,-0x19(%ebp)
 533:	6a 01                	push   $0x1
 535:	57                   	push   %edi
 536:	ff 75 08             	pushl  0x8(%ebp)
 539:	e8 53 fe ff ff       	call   391 <write>
 53e:	8b 55 d4             	mov    -0x2c(%ebp),%edx
      } else {
        putc(fd, c);
 541:	83 c4 10             	add    $0x10,%esp
 544:	83 c6 01             	add    $0x1,%esi
  for(i = 0; fmt[i]; i++){
 547:	0f b6 5e ff          	movzbl -0x1(%esi),%ebx
 54b:	84 db                	test   %bl,%bl
 54d:	74 71                	je     5c0 <printf+0xd0>
    c = fmt[i] & 0xff;
 54f:	0f be cb             	movsbl %bl,%ecx
 552:	0f b6 c3             	movzbl %bl,%eax
    if(state == 0){
 555:	85 d2                	test   %edx,%edx
 557:	74 c7                	je     520 <printf+0x30>
      }
    } else if(state == '%'){
 559:	83 fa 25             	cmp    $0x25,%edx
 55c:	75 e6                	jne    544 <printf+0x54>
      if(c == 'd'){
 55e:	83 f8 64             	cmp    $0x64,%eax
 561:	0f 84 99 00 00 00    	je     600 <printf+0x110>
        printint(fd, *ap, 10, 1);
        ap++;
      } else if(c == 'x' || c == 'p'){
 567:	81 e1 f7 00 00 00    	and    $0xf7,%ecx
 56d:	83 f9 70             	cmp    $0x70,%ecx
 570:	74 5e                	je     5d0 <printf+0xe0>
        printint(fd, *ap, 16, 0);
        ap++;
      } else if(c == 's'){
 572:	83 f8 73             	cmp    $0x73,%eax
 575:	0f 84 d5 00 00 00    	je     650 <printf+0x160>
          s = "(null)";
        while(*s != 0){
          putc(fd, *s);
          s++;
        }
      } else if(c == 'c'){
 57b:	83 f8 63             	cmp    $0x63,%eax
 57e:	0f 84 8c 00 00 00    	je     610 <printf+0x120>
        putc(fd, *ap);
        ap++;
      } else if(c == '%'){
 584:	83 f8 25             	cmp    $0x25,%eax
 587:	0f 84 b3 00 00 00    	je     640 <printf+0x150>
  write(fd, &c, 1);
 58d:	83 ec 04             	sub    $0x4,%esp
 590:	c6 45 e7 25          	movb   $0x25,-0x19(%ebp)
 594:	6a 01                	push   $0x1
 596:	57                   	push   %edi
 597:	ff 75 08             	pushl  0x8(%ebp)
 59a:	e8 f2 fd ff ff       	call   391 <write>
        putc(fd, c);
      } else {
        // Unknown % sequence.  Print it to draw attention.
        putc(fd, '%');
        putc(fd, c);
 59f:	88 5d e7             	mov    %bl,-0x19(%ebp)
  write(fd, &c, 1);
 5a2:	83 c4 0c             	add    $0xc,%esp
 5a5:	6a 01                	push   $0x1
 5a7:	83 c6 01             	add    $0x1,%esi
 5aa:	57                   	push   %edi
 5ab:	ff 75 08             	pushl  0x8(%ebp)
 5ae:	e8 de fd ff ff       	call   391 <write>
  for(i = 0; fmt[i]; i++){
 5b3:	0f b6 5e ff          	movzbl -0x1(%esi),%ebx
        putc(fd, c);
 5b7:	83 c4 10             	add    $0x10,%esp
      }
      state = 0;
 5ba:	31 d2                	xor    %edx,%edx
  for(i = 0; fmt[i]; i++){
 5bc:	84 db                	test   %bl,%bl
 5be:	75 8f                	jne    54f <printf+0x5f>
    }
  }
}
 5c0:	8d 65 f4             	lea    -0xc(%ebp),%esp
 5c3:	5b                   	pop    %ebx
 5c4:	5e                   	pop    %esi
 5c5:	5f                   	pop    %edi
 5c6:	5d                   	pop    %ebp
 5c7:	c3                   	ret    
 5c8:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 5cf:	90                   	nop
        printint(fd, *ap, 16, 0);
 5d0:	83 ec 0c             	sub    $0xc,%esp
 5d3:	b9 10 00 00 00       	mov    $0x10,%ecx
 5d8:	6a 00                	push   $0x0
 5da:	8b 5d d0             	mov    -0x30(%ebp),%ebx
 5dd:	8b 45 08             	mov    0x8(%ebp),%eax
 5e0:	8b 13                	mov    (%ebx),%edx
 5e2:	e8 49 fe ff ff       	call   430 <printint>
        ap++;
 5e7:	89 d8                	mov    %ebx,%eax
 5e9:	83 c4 10             	add    $0x10,%esp
      state = 0;
 5ec:	31 d2                	xor    %edx,%edx
        ap++;
 5ee:	83 c0 04             	add    $0x4,%eax
 5f1:	89 45 d0             	mov    %eax,-0x30(%ebp)
 5f4:	e9 4b ff ff ff       	jmp    544 <printf+0x54>
 5f9:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
        printint(fd, *ap, 10, 1);
 600:	83 ec 0c             	sub    $0xc,%esp
 603:	b9 0a 00 00 00       	mov    $0xa,%ecx
 608:	6a 01                	push   $0x1
 60a:	eb ce                	jmp    5da <printf+0xea>
 60c:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
        putc(fd, *ap);
 610:	8b 5d d0             	mov    -0x30(%ebp),%ebx
  write(fd, &c, 1);
 613:	83 ec 04             	sub    $0x4,%esp
        putc(fd, *ap);
 616:	8b 03                	mov    (%ebx),%eax
  write(fd, &c, 1);
 618:	6a 01                	push   $0x1
        ap++;
 61a:	83 c3 04             	add    $0x4,%ebx
  write(fd, &c, 1);
 61d:	57                   	push   %edi
 61e:	ff 75 08             	pushl  0x8(%ebp)
        putc(fd, *ap);
 621:	88 45 e7             	mov    %al,-0x19(%ebp)
  write(fd, &c, 1);
 624:	e8 68 fd ff ff       	call   391 <write>
        ap++;
 629:	89 5d d0             	mov    %ebx,-0x30(%ebp)
 62c:	83 c4 10             	add    $0x10,%esp
      state = 0;
 62f:	31 d2                	xor    %edx,%edx
 631:	e9 0e ff ff ff       	jmp    544 <printf+0x54>
 636:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 63d:	8d 76 00             	lea    0x0(%esi),%esi
        putc(fd, c);
 640:	88 5d e7             	mov    %bl,-0x19(%ebp)
  write(fd, &c, 1);
 643:	83 ec 04             	sub    $0x4,%esp
 646:	e9 5a ff ff ff       	jmp    5a5 <printf+0xb5>
 64b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 64f:	90                   	nop
        s = (char*)*ap;
 650:	8b 45 d0             	mov    -0x30(%ebp),%eax
 653:	8b 18                	mov    (%eax),%ebx
        ap++;
 655:	83 c0 04             	add    $0x4,%eax
 658:	89 45 d0             	mov    %eax,-0x30(%ebp)
        if(s == 0)
 65b:	85 db                	test   %ebx,%ebx
 65d:	74 17                	je     676 <printf+0x186>
        while(*s != 0){
 65f:	0f b6 03             	movzbl (%ebx),%eax
      state = 0;
 662:	31 d2                	xor    %edx,%edx
        while(*s != 0){
 664:	84 c0                	test   %al,%al
 666:	0f 84 d8 fe ff ff    	je     544 <printf+0x54>
 66c:	89 75 d4             	mov    %esi,-0x2c(%ebp)
 66f:	89 de                	mov    %ebx,%esi
 671:	8b 5d 08             	mov    0x8(%ebp),%ebx
 674:	eb 1a                	jmp    690 <printf+0x1a0>
          s = "(null)";
 676:	bb 66 08 00 00       	mov    $0x866,%ebx
        while(*s != 0){
 67b:	89 75 d4             	mov    %esi,-0x2c(%ebp)
 67e:	b8 28 00 00 00       	mov    $0x28,%eax
 683:	89 de                	mov    %ebx,%esi
 685:	8b 5d 08             	mov    0x8(%ebp),%ebx
 688:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 68f:	90                   	nop
  write(fd, &c, 1);
 690:	83 ec 04             	sub    $0x4,%esp
          s++;
 693:	83 c6 01             	add    $0x1,%esi
 696:	88 45 e7             	mov    %al,-0x19(%ebp)
  write(fd, &c, 1);
 699:	6a 01                	push   $0x1
 69b:	57                   	push   %edi
 69c:	53                   	push   %ebx
 69d:	e8 ef fc ff ff       	call   391 <write>
        while(*s != 0){
 6a2:	0f b6 06             	movzbl (%esi),%eax
 6a5:	83 c4 10             	add    $0x10,%esp
 6a8:	84 c0                	test   %al,%al
 6aa:	75 e4                	jne    690 <printf+0x1a0>
 6ac:	8b 75 d4             	mov    -0x2c(%ebp),%esi
      state = 0;
 6af:	31 d2                	xor    %edx,%edx
 6b1:	e9 8e fe ff ff       	jmp    544 <printf+0x54>
 6b6:	66 90                	xchg   %ax,%ax
 6b8:	66 90                	xchg   %ax,%ax
 6ba:	66 90                	xchg   %ax,%ax
 6bc:	66 90                	xchg   %ax,%ax
 6be:	66 90                	xchg   %ax,%ax

000006c0 <free>:
static Header base;
static Header *freep;

void
free(void *ap)
{
 6c0:	55                   	push   %ebp
  Header *bp, *p;

  bp = (Header*)ap - 1;
  for(p = freep; !(bp > p && bp < p->s.ptr); p = p->s.ptr)
 6c1:	a1 48 0b 00 00       	mov    0xb48,%eax
{
 6c6:	89 e5                	mov    %esp,%ebp
 6c8:	57                   	push   %edi
 6c9:	56                   	push   %esi
 6ca:	53                   	push   %ebx
 6cb:	8b 5d 08             	mov    0x8(%ebp),%ebx
 6ce:	8b 10                	mov    (%eax),%edx
  bp = (Header*)ap - 1;
 6d0:	8d 4b f8             	lea    -0x8(%ebx),%ecx
  for(p = freep; !(bp > p && bp < p->s.ptr); p = p->s.ptr)
 6d3:	39 c8                	cmp    %ecx,%eax
 6d5:	73 19                	jae    6f0 <free+0x30>
 6d7:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 6de:	66 90                	xchg   %ax,%ax
 6e0:	39 d1                	cmp    %edx,%ecx
 6e2:	72 14                	jb     6f8 <free+0x38>
    if(p >= p->s.ptr && (bp > p || bp < p->s.ptr))
 6e4:	39 d0                	cmp    %edx,%eax
 6e6:	73 10                	jae    6f8 <free+0x38>
{
 6e8:	89 d0                	mov    %edx,%eax
 6ea:	8b 10                	mov    (%eax),%edx
  for(p = freep; !(bp > p && bp < p->s.ptr); p = p->s.ptr)
 6ec:	39 c8                	cmp    %ecx,%eax
 6ee:	72 f0                	jb     6e0 <free+0x20>
    if(p >= p->s.ptr && (bp > p || bp < p->s.ptr))
 6f0:	39 d0                	cmp    %edx,%eax
 6f2:	72 f4                	jb     6e8 <free+0x28>
 6f4:	39 d1                	cmp    %edx,%ecx
 6f6:	73 f0                	jae    6e8 <free+0x28>
      break;
  if(bp + bp->s.size == p->s.ptr){
 6f8:	8b 73 fc             	mov    -0x4(%ebx),%esi
 6fb:	8d 3c f1             	lea    (%ecx,%esi,8),%edi
 6fe:	39 fa                	cmp    %edi,%edx
 700:	74 1e                	je     720 <free+0x60>
    bp->s.size += p->s.ptr->s.size;
    bp->s.ptr = p->s.ptr->s.ptr;
  } else
    bp->s.ptr = p->s.ptr;
 702:	89 53 f8             	mov    %edx,-0x8(%ebx)
  if(p + p->s.size == bp){
 705:	8b 50 04             	mov    0x4(%eax),%edx
 708:	8d 34 d0             	lea    (%eax,%edx,8),%esi
 70b:	39 f1                	cmp    %esi,%ecx
 70d:	74 28                	je     737 <free+0x77>
    p->s.size += bp->s.size;
    p->s.ptr = bp->s.ptr;
  } else
    p->s.ptr = bp;
 70f:	89 08                	mov    %ecx,(%eax)
  freep = p;
}
 711:	5b                   	pop    %ebx
  freep = p;
 712:	a3 48 0b 00 00       	mov    %eax,0xb48
}
 717:	5e                   	pop    %esi
 718:	5f                   	pop    %edi
 719:	5d                   	pop    %ebp
 71a:	c3                   	ret    
 71b:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi
 71f:	90                   	nop
    bp->s.size += p->s.ptr->s.size;
 720:	03 72 04             	add    0x4(%edx),%esi
 723:	89 73 fc             	mov    %esi,-0x4(%ebx)
    bp->s.ptr = p->s.ptr->s.ptr;
 726:	8b 10                	mov    (%eax),%edx
 728:	8b 12                	mov    (%edx),%edx
 72a:	89 53 f8             	mov    %edx,-0x8(%ebx)
  if(p + p->s.size == bp){
 72d:	8b 50 04             	mov    0x4(%eax),%edx
 730:	8d 34 d0             	lea    (%eax,%edx,8),%esi
 733:	39 f1                	cmp    %esi,%ecx
 735:	75 d8                	jne    70f <free+0x4f>
    p->s.size += bp->s.size;
 737:	03 53 fc             	add    -0x4(%ebx),%edx
  freep = p;
 73a:	a3 48 0b 00 00       	mov    %eax,0xb48
    p->s.size += bp->s.size;
 73f:	89 50 04             	mov    %edx,0x4(%eax)
    p->s.ptr = bp->s.ptr;
 742:	8b 53 f8             	mov    -0x8(%ebx),%edx
 745:	89 10                	mov    %edx,(%eax)
}
 747:	5b                   	pop    %ebx
 748:	5e                   	pop    %esi
 749:	5f                   	pop    %edi
 74a:	5d                   	pop    %ebp
 74b:	c3                   	ret    
 74c:	8d 74 26 00          	lea    0x0(%esi,%eiz,1),%esi

00000750 <malloc>:
  return freep;
}

void*
malloc(uint nbytes)
{
 750:	55                   	push   %ebp
 751:	89 e5                	mov    %esp,%ebp
 753:	57                   	push   %edi
 754:	56                   	push   %esi
 755:	53                   	push   %ebx
 756:	83 ec 1c             	sub    $0x1c,%esp
  Header *p, *prevp;
  uint nunits;

  nunits = (nbytes + sizeof(Header) - 1)/sizeof(Header) + 1;
 759:	8b 45 08             	mov    0x8(%ebp),%eax
  if((prevp = freep) == 0){
 75c:	8b 3d 48 0b 00 00    	mov    0xb48,%edi
  nunits = (nbytes + sizeof(Header) - 1)/sizeof(Header) + 1;
 762:	8d 70 07             	lea    0x7(%eax),%esi
 765:	c1 ee 03             	shr    $0x3,%esi
 768:	83 c6 01             	add    $0x1,%esi
  if((prevp = freep) == 0){
 76b:	85 ff                	test   %edi,%edi
 76d:	0f 84 ad 00 00 00    	je     820 <malloc+0xd0>
    base.s.ptr = freep = prevp = &base;
    base.s.size = 0;
  }
  for(p = prevp->s.ptr; ; prevp = p, p = p->s.ptr){
 773:	8b 17                	mov    (%edi),%edx
    if(p->s.size >= nunits){
 775:	8b 4a 04             	mov    0x4(%edx),%ecx
 778:	39 ce                	cmp    %ecx,%esi
 77a:	76 72                	jbe    7ee <malloc+0x9e>
 77c:	81 fe 00 10 00 00    	cmp    $0x1000,%esi
 782:	bb 00 10 00 00       	mov    $0x1000,%ebx
 787:	0f 43 de             	cmovae %esi,%ebx
  p = sbrk(nu * sizeof(Header));
 78a:	8d 04 dd 00 00 00 00 	lea    0x0(,%ebx,8),%eax
 791:	89 45 e4             	mov    %eax,-0x1c(%ebp)
 794:	eb 1b                	jmp    7b1 <malloc+0x61>
 796:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 79d:	8d 76 00             	lea    0x0(%esi),%esi
  for(p = prevp->s.ptr; ; prevp = p, p = p->s.ptr){
 7a0:	8b 02                	mov    (%edx),%eax
    if(p->s.size >= nunits){
 7a2:	8b 48 04             	mov    0x4(%eax),%ecx
 7a5:	39 f1                	cmp    %esi,%ecx
 7a7:	73 4f                	jae    7f8 <malloc+0xa8>
 7a9:	8b 3d 48 0b 00 00    	mov    0xb48,%edi
 7af:	89 c2                	mov    %eax,%edx
        p->s.size = nunits;
      }
      freep = prevp;
      return (void*)(p + 1);
    }
    if(p == freep)
 7b1:	39 d7                	cmp    %edx,%edi
 7b3:	75 eb                	jne    7a0 <malloc+0x50>
  p = sbrk(nu * sizeof(Header));
 7b5:	83 ec 0c             	sub    $0xc,%esp
 7b8:	ff 75 e4             	pushl  -0x1c(%ebp)
 7bb:	e8 39 fc ff ff       	call   3f9 <sbrk>
  if(p == (char*)-1)
 7c0:	83 c4 10             	add    $0x10,%esp
 7c3:	83 f8 ff             	cmp    $0xffffffff,%eax
 7c6:	74 1c                	je     7e4 <malloc+0x94>
  hp->s.size = nu;
 7c8:	89 58 04             	mov    %ebx,0x4(%eax)
  free((void*)(hp + 1));
 7cb:	83 ec 0c             	sub    $0xc,%esp
 7ce:	83 c0 08             	add    $0x8,%eax
 7d1:	50                   	push   %eax
 7d2:	e8 e9 fe ff ff       	call   6c0 <free>
  return freep;
 7d7:	8b 15 48 0b 00 00    	mov    0xb48,%edx
      if((p = morecore(nunits)) == 0)
 7dd:	83 c4 10             	add    $0x10,%esp
 7e0:	85 d2                	test   %edx,%edx
 7e2:	75 bc                	jne    7a0 <malloc+0x50>
        return 0;
  }
}
 7e4:	8d 65 f4             	lea    -0xc(%ebp),%esp
        return 0;
 7e7:	31 c0                	xor    %eax,%eax
}
 7e9:	5b                   	pop    %ebx
 7ea:	5e                   	pop    %esi
 7eb:	5f                   	pop    %edi
 7ec:	5d                   	pop    %ebp
 7ed:	c3                   	ret    
    if(p->s.size >= nunits){
 7ee:	89 d0                	mov    %edx,%eax
 7f0:	89 fa                	mov    %edi,%edx
 7f2:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi
      if(p->s.size == nunits)
 7f8:	39 ce                	cmp    %ecx,%esi
 7fa:	74 54                	je     850 <malloc+0x100>
        p->s.size -= nunits;
 7fc:	29 f1                	sub    %esi,%ecx
 7fe:	89 48 04             	mov    %ecx,0x4(%eax)
        p += p->s.size;
 801:	8d 04 c8             	lea    (%eax,%ecx,8),%eax
        p->s.size = nunits;
 804:	89 70 04             	mov    %esi,0x4(%eax)
      freep = prevp;
 807:	89 15 48 0b 00 00    	mov    %edx,0xb48
}
 80d:	8d 65 f4             	lea    -0xc(%ebp),%esp
      return (void*)(p + 1);
 810:	83 c0 08             	add    $0x8,%eax
}
 813:	5b                   	pop    %ebx
 814:	5e                   	pop    %esi
 815:	5f                   	pop    %edi
 816:	5d                   	pop    %ebp
 817:	c3                   	ret    
 818:	8d b4 26 00 00 00 00 	lea    0x0(%esi,%eiz,1),%esi
 81f:	90                   	nop
    base.s.ptr = freep = prevp = &base;
 820:	c7 05 48 0b 00 00 4c 	movl   $0xb4c,0xb48
 827:	0b 00 00 
    base.s.size = 0;
 82a:	bf 4c 0b 00 00       	mov    $0xb4c,%edi
    base.s.ptr = freep = prevp = &base;
 82f:	c7 05 4c 0b 00 00 4c 	movl   $0xb4c,0xb4c
 836:	0b 00 00 
  for(p = prevp->s.ptr; ; prevp = p, p = p->s.ptr){
 839:	89 fa                	mov    %edi,%edx
    base.s.size = 0;
 83b:	c7 05 50 0b 00 00 00 	movl   $0x0,0xb50
 842:	00 00 00 
    if(p->s.size >= nunits){
 845:	e9 32 ff ff ff       	jmp    77c <malloc+0x2c>
 84a:	8d b6 00 00 00 00    	lea    0x0(%esi),%esi
        prevp->s.ptr = p->s.ptr;
 850:	8b 08                	mov    (%eax),%ecx
 852:	89 0a                	mov    %ecx,(%edx)
 854:	eb b1                	jmp    807 <malloc+0xb7>
