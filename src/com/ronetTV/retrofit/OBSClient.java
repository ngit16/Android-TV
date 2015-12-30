package com.ronetTV.retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

import com.ronetTV.data.ActivePlanDatum;
import com.ronetTV.data.ClientDatum;
import com.ronetTV.data.ClientnConfigDatum;
import com.ronetTV.data.DeviceDatum;
import com.ronetTV.data.EPGData;
import com.ronetTV.data.MediaDetailRes;
import com.ronetTV.data.MediaDetailsResDatum;
import com.ronetTV.data.OrderDatum;
import com.ronetTV.data.Paytermdatum;
import com.ronetTV.data.PlanDatum;
import com.ronetTV.data.ResourceIdentifier;
import com.ronetTV.data.ServiceDatum;
import com.ronetTV.data.StatusReqDatum;
import com.ronetTV.data.TemplateDatum;

public interface OBSClient {

	@GET("/mediadevices/client/{clientId}")
	ClientnConfigDatum getClientnConfigDataSync(
			@Path("clientId") String clientId);
	
	@GET("/mediadevices/{device}")
	void getMediaDevice(@Path("device") String device, Callback<DeviceDatum> cb);

	@GET("/orders/{clientId}/activeplans")
	void getActivePlans(@Path("clientId") String clientId,
			Callback<List<ActivePlanDatum>> cb);

	@GET("/clients/template")
	void getTemplate(Callback<TemplateDatum> cb);

	@GET("/plans?planType=prepaid")
	void getPrepaidPlans(Callback<List<PlanDatum>> cb);
	
	@GET("/orders/{planid}/template?template=true")
	void getPlanPayterms(@Path("planid") String planid, Callback<List<Paytermdatum>> cb);

	@GET("/planservices/{clientId}?serviceType=TV")
	ArrayList<ServiceDatum> getPlanServicesSync(
			@Path("clientId") String clientId);

	@GET("/planservices/{clientId}?serviceType=IPTV")
	void getPlanServices(@Path("clientId") String clientId,
			Callback<ArrayList<ServiceDatum>> cb);

	@GET("/epgprogramguide/{channelName}/{reqDate}")
	void getEPGDetails(@Path("channelName") String channelName,
			@Path("reqDate") String reqDate, Callback<EPGData> cb);

	@GET("/assets")
	void getPageCountAndMediaDetails(@Query("filterType") String category,
			@Query("pageNo") String pageNo, @Query("deviceId") String deviceId,
			Callback<MediaDetailRes> cb);

	@GET("/assetdetails/{mediaId}")
	void getMediaDetails(@Path("mediaId") String mediaId,
			@Query("eventId") String eventId,
			@Query("deviceId") String deviceId,
			Callback<MediaDetailsResDatum> cb);

	@GET("/clients/{clientId}")
	void getClinetDetails(@Path("clientId") String clientId,
			Callback<ClientDatum> cb);

	@GET("/orders/{clientId}/orders")
	void getClinetPackageDetails(@Path("clientId") String clientId,
			Callback<List<OrderDatum>> cb);
	
	@PUT("/mediadevices/{device}")
	ResourceIdentifier updateAppStatus(@Path("device") String device,@Body StatusReqDatum request);
}
