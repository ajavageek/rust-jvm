use jni::JNIEnv;
use jni::sys::jint;
use jni::objects::JObject;

#[no_mangle]
pub extern "system" fn Java_ch_frankel_blog_rust_Main_doubleRust(_env: JNIEnv, _obj: JObject, x: jint) -> jint {
    x * 2
}

#[no_mangle]
pub extern "system" fn Java_ch_frankel_blog_rust_Main_timesRust(env: JNIEnv, obj: JObject, x: jint) -> jint {
    let state = env.get_field(obj, "state", "I");
    state.unwrap().i().unwrap() * x
}
