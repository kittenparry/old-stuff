//onCreate()
		WebView browser = ((WebView) findViewById(R.id.browser));
        browser.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }});
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.loadUrl("http://www.popmundo.com/?nofb=1");
