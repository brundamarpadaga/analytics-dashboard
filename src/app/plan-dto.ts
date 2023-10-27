import { LocationBasedPricing } from "./location-based-pricing";

export interface PlanDTO {
    planName: string;
    planType: string;
    validity: number;
    totalSMS: number;
    callsUnlimited: boolean;
    talkTime: number;
    dataPerDay: number;
    dataPerPack: number;
    dataUnit: string;
    locationBasedPricing: LocationBasedPricing;
}
