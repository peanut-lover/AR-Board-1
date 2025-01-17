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

// TweenAlpha
struct TweenAlpha_t2421518635;
// UnityEngine.GameObject
struct GameObject_t1756533147;

#include "codegen/il2cpp-codegen.h"
#include "UnityEngine_UnityEngine_GameObject1756533147.h"

// System.Void TweenAlpha::.ctor()
extern "C"  void TweenAlpha__ctor_m2942256188 (TweenAlpha_t2421518635 * __this, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Single TweenAlpha::get_alpha()
extern "C"  float TweenAlpha_get_alpha_m4057236505 (TweenAlpha_t2421518635 * __this, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Void TweenAlpha::set_alpha(System.Single)
extern "C"  void TweenAlpha_set_alpha_m381940960 (TweenAlpha_t2421518635 * __this, float ___value0, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Void TweenAlpha::Awake()
extern "C"  void TweenAlpha_Awake_m1053840119 (TweenAlpha_t2421518635 * __this, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// System.Void TweenAlpha::OnUpdate(System.Single,System.Boolean)
extern "C"  void TweenAlpha_OnUpdate_m2020918302 (TweenAlpha_t2421518635 * __this, float ___factor0, bool ___isFinished1, const MethodInfo* method) IL2CPP_METHOD_ATTR;
// TweenAlpha TweenAlpha::Begin(UnityEngine.GameObject,System.Single,System.Single)
extern "C"  TweenAlpha_t2421518635 * TweenAlpha_Begin_m128159287 (Il2CppObject * __this /* static, unused */, GameObject_t1756533147 * ___go0, float ___duration1, float ___alpha2, const MethodInfo* method) IL2CPP_METHOD_ATTR;
