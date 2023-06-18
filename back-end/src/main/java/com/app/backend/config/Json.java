// package com.app.backend.config;

// import java.io.IOException;
// import java.io.InputStream;
// import java.io.OutputStream;
// import java.io.Writer;
// import java.lang.reflect.Type;

// import com.app.backend.exception.AppException;
// import com.app.backend.ulti.BusinessException;
// import com.dslplatform.json.DslJson;
// import com.dslplatform.json.JsonWriter;
// import com.dslplatform.json.SerializationException;

// public class Json {
//     private final DslJson<Object> dslJson;
//     private final ThreadLocal<JsonWriter> localWriter;

//     Json() {
//         dslJson = new DslJson<>();
//         localWriter = ThreadLocal.withInitial(dslJson::newWriter);
//     }

//     /**
//      * @param <T>
//      * @param input
//      * @param type
//      * @return
//      */
//     public <T> T fromJson(String input, Type type) {

//         if (input == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         if (type == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         try {
//             byte[] bytes = input.getBytes("UTF-8");
//             return (T) dslJson.deserialize(type, bytes, bytes.length);
//         } catch (IOException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);

//         }
//     }

//     public <T> T fromJson(String input, Class<T> as) {
//         return (T) fromJson(input, (Type) as);
//     }

//     public <T> T fromJson(InputStream stream, Type type) {
//         if (stream == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         if (type == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         try {
//             return (T) dslJson.deserialize(type, stream);
//         } catch (IOException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         }
//     }

//     public <T> T fromJson(InputStream stream, Class<T> as) {
//         return (T) fromJson(stream, (Type) as);
//     }

//     public String toJson(Object obj) {
//         try {
//             JsonWriter writer = localWriter.get();
//             writer.reset();
//             dslJson.serialize(writer, obj);
//             return new String(writer.getByteBuffer(), 0, writer.size(), "UTF-8");
//         } catch (IOException | SerializationException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         }
//     }

//     public String toJson(Object obj, Type type) {
//         if (type == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         try {
//             JsonWriter writer = localWriter.get();
//             writer.reset();
//             if (!dslJson.serialize(writer, type, obj)) {
//                 throw new AppException(BusinessException.JSONB_EXCEPTION);
//             }
//             return new String(writer.getByteBuffer(), 0, writer.size(), "UTF-8");
//         } catch (IOException | SerializationException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         }
//     }

//     public void toJson(Object obj, Writer writer) {
//         if (writer == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);

//         try {
//             JsonWriter jw = localWriter.get();
//             jw.reset();
//             dslJson.serialize(jw, obj);
//             writer.write(new String(jw.getByteBuffer(), 0, jw.size(), "UTF-8"));
//         } catch (IOException | SerializationException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         }
//     }

//     public void toJson(Object obj, Type type, Writer writer) {
//         if (type == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         if (writer == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         try {
//             JsonWriter jw = localWriter.get();
//             jw.reset();
//             if (!dslJson.serialize(jw, type, obj)) {
//                 throw new AppException(BusinessException.JSONB_EXCEPTION);
//             }
//             writer.write(new String(jw.getByteBuffer(), 0, jw.size(), "UTF-8"));
//         } catch (IOException | SerializationException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         }
//     }

//     public void toJson(Object obj, OutputStream stream) {
//         if (stream == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         try {
//             dslJson.serialize(obj, stream);
//         } catch (IOException | SerializationException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         }
//     }

//     public void toJson(Object obj, Type type, OutputStream stream) {
//         if (type == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         if (stream == null)
//             throw new AppException(BusinessException.JSONB_EXCEPTION);
//         JsonWriter jw = localWriter.get();
//         try {
//             jw.reset(stream);
//             if (!dslJson.serialize(jw, type, obj)) {
//                 throw new AppException(BusinessException.JSONB_EXCEPTION);
//             }
//             jw.flush();
//         } catch (SerializationException ex) {
//             throw new AppException(BusinessException.JSONB_EXCEPTION, ex);
//         } finally {
//             jw.reset(null);
//         }
//     }

// }
