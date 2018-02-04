package net.kr9ly.dagger2sampleapplication.app.usecase.list;

import com.uber.autodispose.SingleSubscribeProxy;

import net.kr9ly.dagger2sampleapplication.data.api.SampleApiClient;
import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;
import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;
import net.kr9ly.dagger2sampleapplication.infra.dispose.DisposeHelper;

import java.util.List;

import javax.inject.Inject;

@ViewScope
public class SampleListUseCase {

    private final SampleApiClient apiClient;

    private final DisposeHelper disposeHelper;

    @Inject
    SampleListUseCase(
            SampleApiClient apiClient,
            DisposeHelper disposeHelper
    ) {
        this.apiClient = apiClient;
        this.disposeHelper = disposeHelper;
    }

    public SingleSubscribeProxy<List<SampleListItemEntity>> requestList() {
        return apiClient.getItems()
                .as(disposeHelper.<List<SampleListItemEntity>>autoDispose());
    }
}
