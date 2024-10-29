#include "jni.h"
#include "dllsss_Aop.h"

JNIEXPORT jint JNICALL Java_dllsss_Aop_add(JNIEnv *env, jobject obj, jint a, jint b) 
{
    return a + b;    
}

JNIEXPORT jint JNICALL Java_dllsss_Aop_sub(JNIEnv *env, jobject obj, jint a, jint b) 
{
    return a - b;    
}

JNIEXPORT jint JNICALL Java_dllsss_Aop_mul(JINEnv *env, jobject obj, jint a, jint b) 
{
    return a * b;
}

JNIEXPORT jint JNICALL Java_dllsss_Aop_div(JNIEnv *env, jobject obj, jint a, jint b) 
{
    if (b == 0)
    {
        return 0;
    }

    return (jint)(a / b);
}