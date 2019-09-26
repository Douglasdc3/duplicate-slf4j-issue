open module org.example.test {
	requires java.desktop;
	requires java.xml;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires ch.qos.logback.classic;
	requires ch.qos.logback.core;
	requires org.apache.commons.io;
	requires org.json;
	requires org.kordamp.iconli.core;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.ikonli.materialdesign;
	requires org.kordamp.ikonli.openiconic;
	requires org.kordamp.ikonli.themify;
	requires org.slf4j;
    requires org.apache.httpcomponents.httpcore;
	requires org.apache.httpcomponents.httpclient;
	requires org.pf4j;

	exports org.example.test;
}