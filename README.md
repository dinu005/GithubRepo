# GithubRepo

To execute this application please add your token to com.navi.githubrepo.network.AuthInterceptor in below line
  .header("Authorization", "token <YOUR_TOKEN>")
 
 Replace <YOUR_TOKEN> with yours.
 
Also, add owner and repo in com.navi.githubrepo.viewmodel.GitPullRequestViewModel in below place

val closedPullRequests = gitPullRequestRepo.getClosedPullRequest("OWNER","REPO")
 
currently, in the code, you will this repo.
