package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class RouterData implements Serializable {
    private List<Children> children;
    private String component;
    private String name;
    private String path;
    private String redirect;

    public static class Children implements Serializable{
        private String path;
        private String component;
        private String name;
        private List<Childrens> children;
        private String redirect;

        public static class Childrens implements Serializable{
            private String path;
            private String component;
            private String name;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getComponent() {
                return component;
            }

            public void setComponent(String component) {
                this.component = component;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Childrens> getChildren() {
            return children;
        }

        public void setChildren(List<Childrens> children) {
            this.children = children;
        }

        public String getRedirect() {
            return redirect;
        }

        public void setRedirect(String redirect) {
            this.redirect = redirect;
        }
        @Override
        public String toString() {
            return "Children{" +
                    "path='" + path + '\'' +
                    ", component='" + component + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
