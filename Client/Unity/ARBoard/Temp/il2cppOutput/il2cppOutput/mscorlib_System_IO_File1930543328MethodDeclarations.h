﻿#pragma once

#include "il2cpp-config.h"

#ifndef _MSC_VER
# include <alloca.h>
#else
# include <malloc.h>
#endif

#include <stdint.h>
#include <assert.h>
#include <exception>

// System.IO.FileStream
struct FileStream_t1695958676;
// System.String
struct String_t;
// System.IO.StreamReader
struct StreamReader_t2360341767;
// System.Byte[]
struct ByteU5BU5D_t3397334013;

#include "codegen/il2cpp-codegen.h"
#include "mscorlib_System_String2029220233.h"
#include "mscorlib_System_IO_FileMode236403845.h"

// System.IO.FileStream System.IO.File::Create(System.String)
extern "C"  FileStream_t1695958676 * File_Create_m1378973685 (Il2CppObject * __this /* static, unused */, String_t* ___path0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.IO.FileStream System.IO.File::Create(System.String,System.Int32)
extern "C"  FileStream_t1695958676 * File_Create_m3510380080 (Il2CppObject * __this /* static, unused */, String_t* ___path0, int32_t ___bufferSize1, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Void System.IO.File::Delete(System.String)
extern "C"  void File_Delete_m2115477556 (Il2CppObject * __this /* static, unused */, String_t* ___path0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Boolean System.IO.File::Exists(System.String)
extern "C"  bool File_Exists_m1685968367 (Il2CppObject * __this /* static, unused */, String_t* ___path0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.IO.FileStream System.IO.File::Open(System.String,System.IO.FileMode)
extern "C"  FileStream_t1695958676 * File_Open_m1543461971 (Il2CppObject * __this /* static, unused */, String_t* ___path0, int32_t ___mode1, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.IO.FileStream System.IO.File::OpenRead(System.String)
extern "C"  FileStream_t1695958676 * File_OpenRead_m132329087 (Il2CppObject * __this /* static, unused */, String_t* ___path0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.IO.StreamReader System.IO.File::OpenText(System.String)
extern "C"  StreamReader_t2360341767 * File_OpenText_m4058508963 (Il2CppObject * __this /* static, unused */, String_t* ___path0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Byte[] System.IO.File::ReadAllBytes(System.String)
extern "C"  ByteU5BU5D_t3397334013* File_ReadAllBytes_m4085527721 (Il2CppObject * __this /* static, unused */, String_t* ___path0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
