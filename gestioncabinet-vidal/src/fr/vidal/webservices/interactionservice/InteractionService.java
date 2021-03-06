package fr.vidal.webservices.interactionservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2015-01-19T13:31:17.699+01:00
 * Generated source version: 2.4.6
 * 
 */
@WebService(targetNamespace = "urn:Vidal", name = "interactionService")
@XmlSeeAlso({ObjectFactory.class})
public interface InteractionService {

    @WebMethod
    @RequestWrapper(localName = "searchByInteractionId", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchByInteractionId")
    @ResponseWrapper(localName = "searchByInteractionIdResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchByInteractionIdResponse")
    @WebResult(name = "interaction", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.Interaction searchByInteractionId(
        @WebParam(name = "interactionId", targetNamespace = "urn:Vidal")
        java.lang.Integer interactionId
    );

    @WebMethod
    @RequestWrapper(localName = "searchInteractionCouplesForProductIds", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForProductIds")
    @ResponseWrapper(localName = "searchInteractionCouplesForProductIdsResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForProductIdsResponse")
    @WebResult(name = "interactionResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionResult searchInteractionCouplesForProductIds(
        @WebParam(name = "productIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt productIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );

    @WebMethod
    @RequestWrapper(localName = "getInteractionCouplesForOneProductId", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.GetInteractionCouplesForOneProductId")
    @ResponseWrapper(localName = "getInteractionCouplesForOneProductIdResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.GetInteractionCouplesForOneProductIdResponse")
    @WebResult(name = "interactionResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionResult getInteractionCouplesForOneProductId(
        @WebParam(name = "productId", targetNamespace = "urn:Vidal")
        java.lang.Integer productId,
        @WebParam(name = "productIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt productIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );

    @WebMethod
    @RequestWrapper(localName = "searchInteractionCouplesForCommonNameGroupId", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForCommonNameGroupId")
    @ResponseWrapper(localName = "searchInteractionCouplesForCommonNameGroupIdResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForCommonNameGroupIdResponse")
    @WebResult(name = "interactionCommonNameGroupResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionCommonNameGroupResult searchInteractionCouplesForCommonNameGroupId(
        @WebParam(name = "commonNameGroupId", targetNamespace = "urn:Vidal")
        java.lang.Integer commonNameGroupId,
        @WebParam(name = "commonNameGroupIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt commonNameGroupIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );

    @WebMethod
    @RequestWrapper(localName = "searchInteractionCouplesForProductId", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForProductId")
    @ResponseWrapper(localName = "searchInteractionCouplesForProductIdResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForProductIdResponse")
    @WebResult(name = "interactionResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionResult searchInteractionCouplesForProductId(
        @WebParam(name = "productId", targetNamespace = "urn:Vidal")
        java.lang.Integer productId,
        @WebParam(name = "productIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt productIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );

    @WebMethod
    @RequestWrapper(localName = "getInteractionCouplesForCommonNameGroupIds", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.GetInteractionCouplesForCommonNameGroupIds")
    @ResponseWrapper(localName = "getInteractionCouplesForCommonNameGroupIdsResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.GetInteractionCouplesForCommonNameGroupIdsResponse")
    @WebResult(name = "interactionCommonNameGroupResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionCommonNameGroupResult getInteractionCouplesForCommonNameGroupIds(
        @WebParam(name = "commonNameGroupIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt commonNameGroupIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );

    @WebMethod
    @RequestWrapper(localName = "searchInteractionCouplesForCommonNameGroupIds", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForCommonNameGroupIds")
    @ResponseWrapper(localName = "searchInteractionCouplesForCommonNameGroupIdsResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.SearchInteractionCouplesForCommonNameGroupIdsResponse")
    @WebResult(name = "interactionCommonNameGroupResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionCommonNameGroupResult searchInteractionCouplesForCommonNameGroupIds(
        @WebParam(name = "commonNameGroupIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt commonNameGroupIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );

    @WebMethod
    @RequestWrapper(localName = "getInteractionCouplesForProductIds", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.GetInteractionCouplesForProductIds")
    @ResponseWrapper(localName = "getInteractionCouplesForProductIdsResponse", targetNamespace = "urn:Vidal", className = "fr.vidal.webservices.interactionservice.GetInteractionCouplesForProductIdsResponse")
    @WebResult(name = "interactionResult", targetNamespace = "urn:Vidal")
    public fr.vidal.webservices.interactionservice.InteractionResult getInteractionCouplesForProductIds(
        @WebParam(name = "productIds", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.ArrayOfInt productIds,
        @WebParam(name = "severity", targetNamespace = "urn:Vidal")
        fr.vidal.webservices.interactionservice.InteractionSeverityType severity
    );
}
