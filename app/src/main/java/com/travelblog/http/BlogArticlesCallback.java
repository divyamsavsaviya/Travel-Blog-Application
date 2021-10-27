package com.travelblog.http;

import java.util.List;

public interface BlogArticlesCallback {
    void onSuccess(List<Blog> bLogList);
    void onError();
}
