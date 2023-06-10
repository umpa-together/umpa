# UMPA

UMPA의 서비스들을 통합적으로 관리하는 mono repository

```Node.js + mongoDB```로 구축한 서버를 ```Kotlin + Spring + RDS``` 기반으로 마이그레이션을 진행합니다.

기존에는 음원 정보를 [Apple Music API](https://developer.apple.com/documentation/applemusicapi)를 이용했지만
무료로 이용하기 위해 [Spotify API](https://developer.spotify.com/)를 이용합니다.

***

## Model

현재 mongoDB로 정의한 모델들은 다음과 같습니다.

```
AddedPlaylist
AddedSong
Announcement
Daily
DailyComment
DailyRecomment
Feed
Genre
Guide
Hashtag
Notice
Playlist
PlaylistComment
PlaylistRecomment
RecentKeyword
RelayComment
RelayPlaylist
RelayRecomment
RelaySong
Report
StorySong
Theme
User
```

RDS로 마이그레이션 하기 위한 도메인은 다음과 같습니다.

```
user
playlist
likes
... TBD
```

***

## API

작성되어야 하는 API 목록입니다. (Node.js 기준)

### addedRoutes

- [ ] 곡 담기 ```POST /added```

- [ ] 담은 곡 조회 ```GET /added```

- [ ] 담은 곡 삭제 ```DELETE /added/{id}```

- [ ] 플레이리스트 담기 ```POST /added/playlist/{id}```

- [ ] 담은 플레이리스트 조회 ```GET /added/playlist```

- [ ] 담은 플레이리스트 삭제 ```DELETE /added/playlist/{id}```

### appleMusicRoutes

- [x] 곡 검색 ```GET /searchMusic/song/{songName}```

- [x] ~~아티스트 검색 ```GET /searchMusic/artist/{artistName}```~~

- [x] ~~앨범 검색 ```GET /searchMusic/album/{albumName}```~~

- [x] 다음 페이지 조회 ```GET /searchMusic/next/{next}```
  - <u>곡 검색과 통합</u>
- [x] ~~힌트 조회 ```GET /searchMusic/hint/{term}```~~

### authRoutes

- [x] 회원 가입 ```POST /signUp```

- [x] 로그인 ```POST /signIn```

- [ ] 회원 탈퇴 ```DELETE /withdrawal/{id}```

- [ ] 구글 소셜 로그인 ```POST /social/google```

- [ ] 애플 소셜 로그인 ```POST /social/apple```

- [ ] 카카오 소셜 로그인 ```POST /social/kakao```

- [ ] 네이버 소셜 로그인 ```POST /social/naver```

- [ ] 닉네임 확인 ```GET /nickName/{name}```

### dailyRoutes

- [ ] 데일리 생성 ```POST /daily/```

- [ ] 데일리 수정 ```POST /daily/edit```

- [ ] 데일리 삭제 ```DELETE /daily/{id}```

- [ ] 이미지 업로드 ```POST /daily/imgUpload```

- [ ] 데일리 상세 조회 ```GET /daily/{id}/{postUserId}```

- [ ] 댓글 작성 ```POST /daily/comment/{id}```

- [ ] 댓글 삭제 ```DELETE /daily/comment/{id}/{commentId}```

- [ ] 대댓글 작성 ```POST /daily/recomment/{id}/{commentId}```

- [ ] 대댓글 삭제 ```DELETE /daily/recomment/{id}/{commentId}```

- [ ] 데일리 좋아요 ```POST /daily/like/{id}```

- [ ] 데일리 좋아요 취소 ```DELETE /daily/like/{id}```

- [ ] 댓글 좋아요 ```POST /daily/likecomment/{dailyId}/{commentId}```

- [ ] 댓글 좋아요 취소 ```DELETE /daily/likecomment/{dailyId}/{commentId}```

- [ ] 대댓글 좋아요 ```POST /daily/likerecomment/{dailyId}/{commentId}```

- [ ] 대댓글 좋아요 취소 ```POST /daily/likerecomment/{dailyId}/{commentId}```

### feedRoutes

- [ ] 팔로우한 사람 피드 조회 ```GET /feed/following```

- [ ] 팔로우한 사람 피드 페이지 조회 ```GET /feed/following/{page}```

- [ ] 모든 사람 피드 조회 ```GET /feed/```

- [ ] 모든 사람 피드 페이지 조회 ```GET /feed/{page}```

### mainRoutes

- [ ] 플레이리스트 조회 ```GET /main/playlist```

- [ ] 플레이리스트 페이지 조회 ```GET /main/playlist/{page}```

- [ ] 데일리 조회 ```GET /main/daily```

- [ ] 데일리 페이지 조회 ```GET /main/daily/{page}```

- [ ] 최근 플레이리스트 ```GET /main/recent-playlists```

- [ ] 추천 데일리 조회 ```GET /main/recomment-dailies```

- [ ] 추천 플레이리스트 조회 ```GET /main/recommend-playlists```

- [ ] 추천 dj 조회 ```GET /main/recommend-dj```

### noticeRoutes

- [ ] 공지 작성 ```POST /notice/announcements```

- [ ] 공지 조회 ```GET /notice/announcements```

- [ ] 알림 조회 ```GET /notice/```

- [ ] 알림 페이지 조회 ```GET /notice/{page}```

- [ ] 알림 읽기 ```PUT /notice/{id}```

- [ ] 알림 토큰 설정 ```PUT /notice/token/{noticetoken}```

- [ ] 알림 제거 ```DELETE /notice/```

### playlistRoutes

- [ ] 플레이리스트 생성 ```POST /playlist/```

- [ ] 플레이리스트 수정 ```POST /playlist/edit```

- [ ] 플레이리스트 삭제 ```DELETE /playlist/{id}```

- [ ] 이미지 업로드 ```POST /playlist/imgUpload```

- [ ] 플레이리스트 상세 조회 ```GET /playlist/{id}/{postUserId}```

- [ ] 댓글 작성 ```POST /playlist/comment/{id}```

- [ ] 댓글 삭제 ```DELETE /playlist/comment/{id}/{commentId}```

- [ ] 대댓글 작성 ```POST /playlist/recomment/{id}/{commentId}```

- [ ] 대댓글 삭제 ```DELETE /playlist/recomment/{id}/{commentId}```

- [x] 플레이리스트 좋아요 ```POST /v1/playlists/{id}/likes```

- [x] 플레이리스트 좋아요 취소 ```DELETE /playlists/{id}/likes```

- [x] 댓글 좋아요 ```POST /comments/{id}/likes```

- [x] 댓글 좋아요 취소 ```DELETE /comments/{id}/likes```

- [x] 대댓글 좋아요 ```POST /re-comments/{id}/likes```

- [x] 대댓글 좋아요 취소 ```DELETE /re-comments/{id}/likes```

### relayRoutes

- [ ] 릴레이 플리 등록 ```POST /relay/```

- [ ] 릴레이 플리 대표곡 등록 ```POST /relay/{id}```

- [ ] 릴레이 플리 곡 승인 ```GET /relay/approve```

- [ ] 현재 릴레이 플리 조회 ```GET /relay/```

- [ ] 릴레이 플리 전체 조회 ```GET /relay/lists```

- [ ] 릴레이 플리 페이지 조회 ```GET /relay/lists/{page}```

- [ ] 릴레이 플리 상세 조회 ```GET /relay/{id}```

- [ ] 릴레이 플리 곡 등록 ```POST /relay/song/{playlistId}```

- [ ] 릴레이 플리 곡 조회 ```GET /relay/song/{playlistId}```

- [ ] 릴레이 곡 좋아요 ```PUT /relay/songs-like/{id}```

- [ ] 릴레이 곡 싫어요 ```PUT /relay/songs-unlike/{id}```

- [ ] 릴레이 플리 좋아요 ```PUT /relay/playlist-like/{id}```

- [ ] 릴레이 플리 좋아요 취소 ```PUT /relay/playlist-unlike/{id}```

- [ ] 댓글 작성 ```POST /relay/comment/{id}```

- [ ] 댓글 삭제 ```DELETE /relay/comment/{id}/{commentId}```

- [ ] 대댓글 작성 ```POST /relay/recomment/{id}/{commentId}```

- [ ] 대댓글 삭제 ```DELETE /relay/recomment/{id}/{commentId}```

- [ ] 댓글 좋아요 ```PUT /relay/comments-like/{relayId}/{commentId}```

- [ ] 댓글 좋아요 취소 ```PUT /relay/comments-unlike/{relayId}/{commentId}```

- [ ] 대댓글 좋아요 ```PUT /relay/recomments-like/{relayId}/{commentId}```

- [ ] 대댓글 좋아요 취소 ```PUT /relay/recomments-unlike/{relayId}/{commentId}```


### reportRoutes

- [ ] 신고하기 ```POST /report```

### searchRoutes

- [ ] 최근 키워드 조회 ```GET /search/keyword```

- [ ] 최근 키워드 삭제 ```DELETE /search/keyword/{id}```

- [ ] 모든 키워드 삭제 ```DELETE /search/keywordAll```

- [ ] 다음 곡 결과 가져오기 ```GET /search/next/{next}```

- [ ] 컨텐츠 검색 ```GET /search/{term}```

- [ ] 선택된 컨텐츠 가져오기 ```GET /search/song/{id}```

- [ ] 해시태그로 컨텐츠 검색 ```GET /search/hashtag/{id}```

### storyRoutes

- [ ] 스토리 포스트 ```POST /story/```

- [ ] 스토리 제거 ```DELETE /story/{id}```

- [ ] 내 스토리 조회 ```GET /story/```

- [ ] 다른 사람 스토리 조회 ```GET /story/other```

- [ ] 팔로우한 사람 스토리 조회 ```GET /story/following```

- [ ] 스토리 읽기 ```PUT /story/{id}```

- [ ] 스토리 캘린더 조회 ```GET /story/calendar/{userId}```

- [ ] 스토리 좋아요 ```PUT /story/like/{id}```

- [ ] 스토리 좋아요 취소 ```PUT /story/unlike/{id}```

### userRoutes

- [ ] 내 정보 조회 ```GET /user```

- [ ] 다른 사람 정보 조회 ```GET /user/other/{id}```

- [ ] 프로필 수정 ```POST /user/editProfile```

- [ ] 이미지 수정 ```POST /user/editImage```

- [ ] 팔로우 정보 조회 ```GET /user/follow/{id}```

- [ ] 팔로우 ```GET /user/follow/{id}```

- [ ] 언팔로우 ```DELETE /user/follow/{id}```

- [ ] 대표곡 가져오기 ```GET /user/songs/{userId}```

- [ ] 대표곡 설정 ```POST /user/songs```

- [ ] 가이드 조회 ```GET /user/guide/{type}```

- [ ] 장르 조회 ```GET /user/genre```

- [ ] 장르 등록 ```POST /user/genre```

- [ ] 유저 차단 ```PUT /user/block/{id}```

- [ ] 유저 차단 해제 ```PUT /user/unblock/{id}```
