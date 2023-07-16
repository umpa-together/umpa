package com.umpa.core.controller.v1.content.daily

import com.umpa.commons.api.response.CommonApiResponse
import com.umpa.core.controller.v1.content.daily.request.DailyCreateRequest
import com.umpa.core.controller.v1.content.daily.response.DailyDetailResponse
import com.umpa.core.domain.content.daily.DailyCreateService
import com.umpa.core.domain.content.daily.DailyReadService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/dailies")
class DailyController(
    private val dailyCreateService: DailyCreateService,
    private val dailyReadService: DailyReadService
) {
    @PostMapping
    fun create(
        @Valid @RequestBody
        body: DailyCreateRequest
    ): CommonApiResponse<DailyDetailResponse> {
        // TODO userId resolve
        val result = dailyCreateService.create(body.toDomain(0L))
        return CommonApiResponse.success(DailyDetailResponse(result))
    }

    @GetMapping("/{id}")
    fun getDetail(
        @PathVariable id: Long
    ): CommonApiResponse<DailyDetailResponse> {
        // TODO userId resolve
        val result = dailyReadService.readById(id, 0L)
        return CommonApiResponse.success(DailyDetailResponse(result))
    }
}
