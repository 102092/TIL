# my-first-board

### 유스케이스



사용자 -- 게시글리스트.



1. 게시글리스트페이지 

   1.1 게시글 읽기

   ​	1.1.1 댓글 작성 -- 비밀번호체크

   ​	1.1.2 댓글 삭제 --비밀번호체크

   ​	1.1.3 댓글 수정 -- 비밀번호체크

   1.2 게시글 작성

   ​	1.2.1 파일,사진 업로드

   1.3 게시글 삭제 --비밀번호체크

   1.4 게시글 수정 --비밀번호체크

   1.5 게시글 sorting

   1.6 게시글 검색



- 작성,수정,삭제시 해당 유저만 할 수 있도록 비밀번호 체크들어감
- 세션을 통해서 해당 유저만 삭제,수정 클릭이 나타나도록



```JAVA
int final PAGE_SIZE = 0;

//방법1
pageCount = totalCount / PAGE_SIZE;
if((totalCount % PAGE_SIZE)!=0)
    pageCount++;
//방법2
pageCount = (int)Math.ceil(totalCount / (PAGE_SIZE+0.0));

//현재 페이지 그룹 설정
int curGroup = (curPage-1)/GROUP_SIZE;
```

```sql
drop table bbs purge;

create table bbs(
bid  number(6)  primary key,  --글번호
subject 	varchar2(100),    --제목
writer 		varchar2(20),     ---작성자
password 	varchar2(15),     --비밀번호
idate		date,             --작성일
contents        varchar2(2000),  --글내용
email           varchar2(50), --이메일
ip		varchar2(30), --작성자 pc ip
fileYN		char(1)   default 'N' check( fileYN in('Y','N')) ,   --file첨부 여부
rcount		number(5)  default 0,   --조회수 
vcount 		number (5)  default 0  --추천
);

drop sequence bbs_seq;
create sequence bbs_seq nocache;


create table bbs_comment (
cmid    number(6)  primary key, 
rbid   number(6), 
writer varchar2(20), 
idate  date, 
contents  varchar2(1000), 
password   varchar2(15), 
ip      varchar2(30)
);

drop sequence comment_seq;
create sequence comment_seq nocache;


insert into bbs (bid, subject, writer, idate, contents, password, ip)
values (bbs_seq.nextval, '테스트', '게시판지기', sysdate, 
'게시판 테스트입니다', '1234', '70.12.50.130');

insert into bbs_comment (cmid, rbid, writer, idate, contents, password, ip
) values (comment_seq.nextval, -1, '관리자', sysdate, 
'댓글 테스트입니다', '1234', '70.12.50.131');
commit;


create table bbs_file (
fid   number primary key,
rbid   number ,
filename  varchar2(50),
filetype   varchar2(15)
);

 
create sequence bbsfile_seq nocache;
```

