package com.example.avtoelon.data;

import com.example.avtoelon.model.AutoCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Data {

    static List<String> imageList = Arrays.asList(
            "https://kluz-photos-alaps.kcdn.online/webp/e2/e2148af9-5901-47aa-85a0-cf6517b7e57e/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/e2/e2148af9-5901-47aa-85a0-cf6517b7e57e/2-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/e2/e2148af9-5901-47aa-85a0-cf6517b7e57e/3-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/58/5861e66e-5db9-41e2-878a-232cb32b7313/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/58/5861e66e-5db9-41e2-878a-232cb32b7313/2-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/58/5861e66e-5db9-41e2-878a-232cb32b7313/5-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/b1/b1a1452c-888d-47c0-b3f3-b125dab24f6c/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/b1/b1a1452c-888d-47c0-b3f3-b125dab24f6c/3-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/b1/b1a1452c-888d-47c0-b3f3-b125dab24f6c/2-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/f1/f10c6bc7-58b9-4eed-aeb6-108a39cbf088/12-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/f1/f10c6bc7-58b9-4eed-aeb6-108a39cbf088/14-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/f1/f10c6bc7-58b9-4eed-aeb6-108a39cbf088/16-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/82/82ef9167-d038-440c-8788-7ba2c9beda49/4-60x45.webp",
            "https://kluz-photos-alaps.kcdn.online/webp/80/8091d464-2552-4bbb-a7c5-fcbbb6058c7c/11-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/80/8091d464-2552-4bbb-a7c5-fcbbb6058c7c/10-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/67/67b816d7-4994-4124-bbbf-3391ec902152/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/67/67b816d7-4994-4124-bbbf-3391ec902152/4-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/67/67b816d7-4994-4124-bbbf-3391ec902152/3-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/dd/dde79d1e-4d56-459e-95a2-db3d28b64313/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/dd/dde79d1e-4d56-459e-95a2-db3d28b64313/2-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/dd/dde79d1e-4d56-459e-95a2-db3d28b64313/4-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/ee/ee89a48e-60d6-49d4-bfb3-9e52d6eed699/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/ee/ee89a48e-60d6-49d4-bfb3-9e52d6eed699/3-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/ee/ee89a48e-60d6-49d4-bfb3-9e52d6eed699/4-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/52/52fc18e0-1fcf-45b7-92d3-24fc2e0ca123/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/52/52fc18e0-1fcf-45b7-92d3-24fc2e0ca123/2-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/52/52fc18e0-1fcf-45b7-92d3-24fc2e0ca123/1-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/e5/e58150f3-f4a7-47f1-8bb1-99a4aec66609/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/e5/e58150f3-f4a7-47f1-8bb1-99a4aec66609/3-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/e5/e58150f3-f4a7-47f1-8bb1-99a4aec66609/2-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/32/329a2998-4f54-4c0b-8437-634c7d775008/1-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/32/329a2998-4f54-4c0b-8437-634c7d775008/2-240x180.jpg",
            "https://kluz-photos-alaps.kcdn.online/webp/32/329a2998-4f54-4c0b-8437-634c7d775008/3-240x180.jpg",

            "https://kluz-photos.kcdn.online/webp/79/79500a89-07b7-4546-b49f-f226e95acc91/1-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/79/79500a89-07b7-4546-b49f-f226e95acc91/2-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/79/79500a89-07b7-4546-b49f-f226e95acc91/3-240x180.jpg",

            "https://kluz-photos.kcdn.online/webp/96/960b3724-b4d7-4e5a-addb-300a7592d05d/1-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/96/960b3724-b4d7-4e5a-addb-300a7592d05d/2-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/96/960b3724-b4d7-4e5a-addb-300a7592d05d/2-240x180.jpg",

            "https://kluz-photos.kcdn.online/webp/78/784fdddc-1fe7-42d4-b7dd-0471166bd8ac/1-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/78/784fdddc-1fe7-42d4-b7dd-0471166bd8ac/2-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/78/784fdddc-1fe7-42d4-b7dd-0471166bd8ac/4-240x180.jpg",

            "https://kluz-photos.kcdn.online/webp/cb/cbd633ca-6c8f-47c2-8c3a-ce9b9ed961d8/2-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/cb/cbd633ca-6c8f-47c2-8c3a-ce9b9ed961d8/4-240x180.jpg",
            "https://kluz-photos.kcdn.online/webp/cb/cbd633ca-6c8f-47c2-8c3a-ce9b9ed961d8/5-240x180.jpg",

            "https://kluz-photos-alakt.kcdn.online/webp/5f/5f331cfa-57bf-44f8-b1cd-38ab3424330c/1-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/5f/5f331cfa-57bf-44f8-b1cd-38ab3424330c/2-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/5f/5f331cfa-57bf-44f8-b1cd-38ab3424330c/3-240x180.jpg",

            "https://kluz-photos-alakt.kcdn.online/webp/6c/6c014844-e34d-4177-ba5c-a7369abe5be1/1-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/6c/6c014844-e34d-4177-ba5c-a7369abe5be1/3-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/6c/6c014844-e34d-4177-ba5c-a7369abe5be1/2-240x180.jpg",

            "https://kluz-photos-alakt.kcdn.online/webp/c8/c8acb61e-98fc-4431-8207-9cb5a95eceb9/1-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/c8/c8acb61e-98fc-4431-8207-9cb5a95eceb9/2-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/c8/c8acb61e-98fc-4431-8207-9cb5a95eceb9/4-240x180.jpg",

            "https://kluz-photos-alakt.kcdn.online/webp/cb/cb6f3573-2e99-46b0-9e0b-e918af9821cb/1-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/cb/cb6f3573-2e99-46b0-9e0b-e918af9821cb/2-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/cb/cb6f3573-2e99-46b0-9e0b-e918af9821cb/4-240x180.jpg",

            "https://kluz-photos-alaps.kcdn.online/webp/7c/7cc61e21-d92a-40e4-abf9-f22d5a2dbf69/1-240x180.webp",
            "https://kluz-photos-alakt.kcdn.online/webp/9d/9d43c6c1-8233-4716-9569-24fecb205177/3-240x180.jpg",
            "https://kluz-photos-alakt.kcdn.online/webp/9d/9d43c6c1-8233-4716-9569-24fecb205177/2-240x180.jpg"
    );

    public static ArrayList<AutoCar> getAutoList() {
        ArrayList<AutoCar> autoCarList = new ArrayList<>();
        autoCarList.add(new AutoCar(1, "Equinox ", "Chevrolet ", "", "2021 yil ", "Samarqand ",
                "32 000 km ", "Kulrang ", 36000, "23 Yanvar ", 2354, imageList.get(0), false));
        autoCarList.add(new AutoCar(2, "Cobalt ", "Chevrolet ", "2", "2015 yil ", "Namangan ",
                "171 000 km ", "Oq ", 10500, "20 Dekabr ", 2484, imageList.get(3), false));
        autoCarList.add(new AutoCar(3, "Nexia 3 ", "Chevrolet ", "4", "2019 yil ", "Toshkent ",
                "83 000 km ", "Oq ", 13000, "2 Yanvar ", 1457, imageList.get(6), false));
        autoCarList.add(new AutoCar(4, "Lacestti ", "Chevrolet ", "2", "2012 yil ", "Toshkent ",
                "135 000 km ", "Oq ", 10300, "13 Yanvar ", 7897, imageList.get(9), false));
        autoCarList.add(new AutoCar(5, "Captiva ", "Chevrolet ", "4", "2014 yil ", "Navoiy ",
                "80 000 km ", "Oq ", 22000, "10 Noyabr ", 4578, imageList.get(12), false));
        autoCarList.add(new AutoCar(6, "Cobalt ", "Chevrolet ", "2", "2014 yil ", "Buxoro ",
                "42 400 km ", "Mokriy asfalt ", 11000, "9 Yanvar ", 6589, imageList.get(15), false));
        autoCarList.add(new AutoCar(7, "Malibu ", "Chevrolet ", "3", "2015 yil ", "Andijon ",
                "93 000 km ", "Xameleon ", 17500, "8 Dekabr ", 7845, imageList.get(18), false));
        autoCarList.add(new AutoCar(8, "Epica ", "Chevrolet ", "2", "2020 yil ", "Jizzax ",
                "115 000 km ", "Qora ", 11900, "17 Avgust ", 7145, imageList.get(21), false));
        autoCarList.add(new AutoCar(9, "Nexia 2 ", "Chevrolet ", "4", "2015 yil ", "Samarqand ",
                "105 000 km ", "Mokriy asfalt ", 8500, "2 Iyul ", 7412, imageList.get(24), false));
        autoCarList.add(new AutoCar(10, "Labo ", "Chevrolet ", "", "2021 yil ", "Farg'ona ",
                "25 000 km ", "Oq ", 7000, "17 Oktabr ", 1458, imageList.get(27), false));
        autoCarList.add(new AutoCar(11, "Epica ", "Chevrolet ", "1", "2011 yil ", "Termiz ",
                "175 000 km ", "Qora ", 8950, "15 Mart ", 1498, imageList.get(30), false));
        autoCarList.add(new AutoCar(12, "Damas ", "Chevrolet ", "", "2020 yil ", "Termiz ",
                "173 900 km ", "Oq ", 8400, "10 Aprel ", 6523, imageList.get(33), false));
        autoCarList.add(new AutoCar(13, "Gentra ", "Chevrolet ", "1", "2015 yil ", "Navoiy ",
                "102 000 km ", "Delfin ", 11800, "20 Yanvar ", 2547, imageList.get(36), false));
        autoCarList.add(new AutoCar(14, "Spark ", "Chevrolet ", "4", "2018 yil ", "Toshkent ",
                "93 000 km ", "Jigarrang ", 10300, "14 Fevral ", 1489, imageList.get(39), false));
        autoCarList.add(new AutoCar(15, "Matiz ", "Chevrolet ", "1", "2007 yil ", "Toshkent ",
                "196 000 km ", "Oq ", 4500, "1 Yanvar ", 2547, imageList.get(42), false));
        autoCarList.add(new AutoCar(16, "Lacetti ", "Chevrolet ", "3", "2020 yil ", "Samarqand ",
                "120 000 km ", "Oq ", 15800, "18 Dekabr ", 2057, imageList.get(45), false));
        autoCarList.add(new AutoCar(17, "Captiva ", "Chevrolet ", "3", "2013 yil ", "Jizzax ",
                "63 000 km ", "Oq ", 18000, "18 Dekabr ", 2609, imageList.get(48), false));
        autoCarList.add(new AutoCar(18, "Damas ", "Chevrolet ", "", "2010 yil ", "Farg'ona ",
                "193 000 km ", "Yashil rang ", 5500, "25 Dekabr ", 8021, imageList.get(51), false));
        autoCarList.add(new AutoCar(19, "Spark ", "Chevrolet ", "4", "2023 yil ", "Termiz ",
                "17 000 km ", "Oq ", 12500, "17 Dekabr ", 4560, imageList.get(54), false));
        autoCarList.add(new AutoCar(20, "Lacetti ", "Chevrolet ", "3", "2023 yil ", "Namangan ",
                "21 000 km ", "Qora ", 19500, "29 Dekabr ", 4203, imageList.get(57), false));
        return autoCarList;
    }

}
