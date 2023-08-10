package store_order_outwards_mgmt.services.mode0_sale_passthru;

import java.util.concurrent.CompletableFuture;

public interface I_StoreOrderMode0SalePassthru_Service
{
    public CompletableFuture<Void> resource_Alloc();
    public CompletableFuture<Void> asset_Alloc();        
}