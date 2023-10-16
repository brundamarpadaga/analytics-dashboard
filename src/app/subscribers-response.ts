import { Subscriber } from "./subscriber";
export interface SubscribersResponse 
{
    subscriber: Subscriber;
    planType : String;
    locationBasedPricing: number;
}
  