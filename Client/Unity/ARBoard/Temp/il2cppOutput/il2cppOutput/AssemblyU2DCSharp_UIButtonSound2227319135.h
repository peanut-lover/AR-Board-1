﻿#pragma once

#include "il2cpp-config.h"

#ifndef _MSC_VER
# include <alloca.h>
#else
# include <malloc.h>
#endif

#include <stdint.h>

// UnityEngine.AudioClip
struct AudioClip_t1932558630;

#include "UnityEngine_UnityEngine_MonoBehaviour1158329972.h"
#include "AssemblyU2DCSharp_UIButtonSound_Trigger462638590.h"

#ifdef __clang__
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Winvalid-offsetof"
#pragma clang diagnostic ignored "-Wunused-variable"
#endif

// UIButtonSound
struct  UIButtonSound_t2227319135  : public MonoBehaviour_t1158329972
{
public:
	// UnityEngine.AudioClip UIButtonSound::audioClip
	AudioClip_t1932558630 * ___audioClip_2;
	// UIButtonSound/Trigger UIButtonSound::trigger
	int32_t ___trigger_3;
	// System.Single UIButtonSound::volume
	float ___volume_4;
	// System.Single UIButtonSound::pitch
	float ___pitch_5;

public:
	inline static int32_t get_offset_of_audioClip_2() { return static_cast<int32_t>(offsetof(UIButtonSound_t2227319135, ___audioClip_2)); }
	inline AudioClip_t1932558630 * get_audioClip_2() const { return ___audioClip_2; }
	inline AudioClip_t1932558630 ** get_address_of_audioClip_2() { return &___audioClip_2; }
	inline void set_audioClip_2(AudioClip_t1932558630 * value)
	{
		___audioClip_2 = value;
		Il2CppCodeGenWriteBarrier(&___audioClip_2, value);
	}

	inline static int32_t get_offset_of_trigger_3() { return static_cast<int32_t>(offsetof(UIButtonSound_t2227319135, ___trigger_3)); }
	inline int32_t get_trigger_3() const { return ___trigger_3; }
	inline int32_t* get_address_of_trigger_3() { return &___trigger_3; }
	inline void set_trigger_3(int32_t value)
	{
		___trigger_3 = value;
	}

	inline static int32_t get_offset_of_volume_4() { return static_cast<int32_t>(offsetof(UIButtonSound_t2227319135, ___volume_4)); }
	inline float get_volume_4() const { return ___volume_4; }
	inline float* get_address_of_volume_4() { return &___volume_4; }
	inline void set_volume_4(float value)
	{
		___volume_4 = value;
	}

	inline static int32_t get_offset_of_pitch_5() { return static_cast<int32_t>(offsetof(UIButtonSound_t2227319135, ___pitch_5)); }
	inline float get_pitch_5() const { return ___pitch_5; }
	inline float* get_address_of_pitch_5() { return &___pitch_5; }
	inline void set_pitch_5(float value)
	{
		___pitch_5 = value;
	}
};

#ifdef __clang__
#pragma clang diagnostic pop
#endif
