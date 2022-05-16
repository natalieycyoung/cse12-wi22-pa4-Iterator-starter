MyLinkedList.class: MyLinkedList.java
	javac -g MyLinkedList.java

MyLinkedListPublicTester.class: MyLinkedListPublicTester.java
	javac -g -cp ".;./libs/*" MyLinkedListPublicTester.java MyLinkedList.java

MyLinkedListCustomTester.class: MyLinkedListCustomTester.java
	javac -g -cp ".;./libs/*" MyLinkedListCustomTester.java MyLinkedList.java

test-public: MyLinkedList.java MyLinkedList.class MyLinkedListPublicTester.class
	java -cp ".;./libs/*" org.junit.runner.JUnitCore MyLinkedListPublicTester
	
test-private: MyLinkedList.java MyLinkedList.class MyLinkedListCustomTester.class
	java -cp ".;./libs/*" org.junit.runner.JUnitCore MyLinkedListCustomTester

debug-public: MyLinkedList.java MyLinkedList.class MyLinkedListPublicTester.class
	jdb -classpath ".;./libs/*" org.junit.runner.JUnitCore MyLinkedListTester

debug-private: MyLinkedList.java MyLinkedList.class MyLinkedListCustomTester.class
	jdb -classpath ".;./libs/*" org.junit.runner.JUnitCore MyLinkedListCustomTester
