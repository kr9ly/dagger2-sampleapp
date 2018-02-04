package net.kr9ly.dagger2sampleapplication.app.usecase.detail;

import com.uber.autodispose.SingleSubscribeProxy;

import net.kr9ly.dagger2sampleapplication.data.api.SampleApiClient;
import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;
import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;
import net.kr9ly.dagger2sampleapplication.infra.dispose.DisposeHelper;

import javax.inject.Inject;

@ViewScope
public class SampleDetailUseCase {

    private final SampleApiClient apiClient;

    private final DisposeHelper disposeHelper;

    @Inject
    public SampleDetailUseCase(
            SampleApiClient apiClient,
            DisposeHelper disposeHelper
    ) {
        this.apiClient = apiClient;
        this.disposeHelper = disposeHelper;
    }

    public SingleSubscribeProxy<SampleListItemEntity> requestDetail(int id) {
        return apiClient.getItem(id)
                .as(disposeHelper.<SampleListItemEntity>autoDispose());
    }
}
