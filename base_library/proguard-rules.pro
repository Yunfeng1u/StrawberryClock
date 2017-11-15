# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/luyunfeng/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-printseeds seeds.txt
-printusage unused.txt
-printmapping build/outputs/mapping/release/mapping.txt

-optimizationpasses 5
-dontusemixedcaseclassnames             #混淆时不会产生形形色色的类名
-dontskipnonpubliclibraryclasses        #指定不去忽略非公共的类库
-dontpreverify                          #不预校验
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*       #优化

-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

#-obfuscationdictionary dictionary.txt
#-classobfuscationdictionary dictionary.txt
#-packageobfuscationdictionary dictionary.txt

# 通过成员来指定哪些类的类名和成员不被混淆
-keepclasseswithmembers public class com.wannar.base_library.** {
    public <methods>;
}



