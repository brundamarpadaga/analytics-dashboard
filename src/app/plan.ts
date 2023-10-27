export interface Plan {
    planId: string;
    planName: string;
    planType: string;
    validity: number;
    totalSMS: number;
    callsUnlimited: boolean;
    talkTime: number;
    dataPerDay: number;
    dataPerPack: number;
    dataUnit: string;
    locationBasedPricing: { [key: string]: number };
}
