﻿#pragma once

#include "il2cpp-config.h"

#ifndef _MSC_VER
# include <alloca.h>
#else
# include <malloc.h>
#endif

#include <stdint.h>

// System.String
struct String_t;

#include "UnityEngine_UnityEngine_MonoBehaviour1158329972.h"

#ifdef __clang__
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Winvalid-offsetof"
#pragma clang diagnostic ignored "-Wunused-variable"
#endif

// UILocalize
struct  UILocalize_t3754440953  : public MonoBehaviour_t1158329972
{
public:
	// System.String UILocalize::key
	String_t* ___key_2;
	// System.String UILocalize::mLanguage
	String_t* ___mLanguage_3;
	// System.Boolean UILocalize::mStarted
	bool ___mStarted_4;

public:
	inline static int32_t get_offset_of_key_2() { return static_cast<int32_t>(offsetof(UILocalize_t3754440953, ___key_2)); }
	inline String_t* get_key_2() const { return ___key_2; }
	inline String_t** get_address_of_key_2() { return &___key_2; }
	inline void set_key_2(String_t* value)
	{
		___key_2 = value;
		Il2CppCodeGenWriteBarrier(&___key_2, value);
	}

	inline static int32_t get_offset_of_mLanguage_3() { return static_cast<int32_t>(offsetof(UILocalize_t3754440953, ___mLanguage_3)); }
	inline String_t* get_mLanguage_3() const { return ___mLanguage_3; }
	inline String_t** get_address_of_mLanguage_3() { return &___mLanguage_3; }
	inline void set_mLanguage_3(String_t* value)
	{
		___mLanguage_3 = value;
		Il2CppCodeGenWriteBarrier(&___mLanguage_3, value);
	}

	inline static int32_t get_offset_of_mStarted_4() { return static_cast<int32_t>(offsetof(UILocalize_t3754440953, ___mStarted_4)); }
	inline bool get_mStarted_4() const { return ___mStarted_4; }
	inline bool* get_address_of_mStarted_4() { return &___mStarted_4; }
	inline void set_mStarted_4(bool value)
	{
		___mStarted_4 = value;
	}
};

#ifdef __clang__
#pragma clang diagnostic pop
#endif
