<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

<button type="button" class="btn btn-primary">Primary</button>
<button type="button" class="btn btn-secondary">Secondary</button>
<button type="button" class="btn btn-success">Success</button>
<button type="button" class="btn btn-danger">Danger</button>
<button type="button" class="btn btn-warning">Warning</button>
<button type="button" class="btn btn-info">Info</button>
<button type="button" class="btn btn-light">Light</button>
<button type="button" class="btn btn-dark">Dark</button>

<button type="button" class="btn btn-link">Link</button>

<main class="main">
	<section class="container">
		<!--전체 리스트 시작-->
		<article class="story-list" id="storyList">

			<!--전체 리스트 아이템-->
			<div class="story-list__item">
				<div class="sl__item__header">
					<div>
						<img class="profile-image" src="#"
							onerror="this.src='/images/person.jpeg'" />
					</div>
					<div>TherePrograming</div>
				</div>

				<div class="sl__item__img">
					<img src="/images/home.jpg" />
				</div>

				<div class="sl__item__contents">
					<div class="sl__item__contents__icon">

						<button>
							<i class="fas fa-heart active" id="storyLikeIcon-1" onclick="toggleLike()"></i>
						</button>
					</div>

					<span class="like"><b id="storyLikeCount-1">3 </b>likes</span>

					<div class="sl__item__contents__content">
						<p>등산하는 것이 너무 재밌네요</p>
					</div>

					<div id="storyCommentList-1">

						<div class="sl__item__contents__comment" id="storyCommentItem-1"">
							<p>
								<b>Lovely :</b> 부럽습니다.
							</p>

							<button>
								<i class="fas fa-times"></i>
							</button>

						</div>

					</div>

					<div class="sl__item__input">
						<input type="text" placeholder="댓글 달기..." id="storyCommentInput-1" />
						<button type="button" onClick="addComment()">게시</button>
					</div>

				</div>
			</div>

		</article>
	</section>
</main>
<script src="/js/story.js"></script>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
