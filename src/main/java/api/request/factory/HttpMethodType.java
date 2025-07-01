package api.request.factory;

import api.request.HttpRequest;

public enum HttpMethodType {
    GET {
        @Override
        public HttpRequest createHttpRequest() {
            return null;
        }
    }, GET_WITH_QUERY {
        @Override
        public HttpRequest createHttpRequest() {
            return null;
        }
    },POST {
        @Override
        public HttpRequest createHttpRequest() {
            return null;
        }
    },PUT {
        @Override
        public HttpRequest createHttpRequest() {
            return null;
        }
    },DELETE {
        @Override
        public HttpRequest createHttpRequest() {
            return null;
        }
    };

    public abstract HttpRequest createHttpRequest();
}
