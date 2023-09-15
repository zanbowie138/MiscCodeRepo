import Image from "next/image";
import { NextPage } from "next/types";

import Card from "../../components/Card";
import styles from "../../styles/About.module.scss";
import aboutMainImg from "/public/img/aboutPageMainPicture.png";

const AboutPage: NextPage = ({}) => {
    const officer_info: {position: string; name: string; img_path: string}[] = [
        {
            position: "President",
            name: "Reet Sinha",
            img_path: "/public/img/officer_images/reet_profile.webp"
        },
        {
            position: "FRC Director",
            name: "Anaya Zia",
            img_path: "/public/img/officer_images/anaya_profile.webp"
        },
        {
            position: "FTC Director",
            name: "Jadon Lee",
            img_path: "/public/img/officer_images/jadon_profile.webp"
        },
        {
            position: "Event Director",
            name: "Aakash Reddy",
            img_path: "/public/img/officer_images/aakash_profile.webp"
        },
        {
            position: "Director of Finance",
            name: "Shaurya Pathania",
            img_path: "/public/img/officer_images/shaurya_profile.webp"
        },
        {
            position: "Director of Communications",
            name: "Aanchal Save",
            img_path: "/public/img/officer_images/aanchal_profile.webp"
        },
        {
            position: "Director of External Affairs",
            name: "Avi Rajesh",
            img_path: "/public/img/officer_images/avi_profile.webp"
        }

    ];
    return (
        <>
            <div className={styles.image_cover}>
                <Image src={aboutMainImg} alt="Hulsey and his robot children" fill placeholder="blur" priority></Image>
            </div>
            <div className="container flex flex-col items-center">
                <Card className="m-8 w-fit !py-5">
                    <h1 className="w-full p-0 text-6xl font-normal text-center text-dynamite-500">About Us</h1>
                </Card>
                <div className="sm:px-16">
                    <p className="text-lg">
                        Westwood Robotics began participating in the FIRST Robotics Competition in 2008. We got our start by working out of our
                        President&apos;s small garage, and eventually moved into our school&apos;s state-of-the-art MakerSpace. Throughout the years,
                        we&apos;ve made it our mission to instill the core FIRST principles as well as STEM knowledge into all of our members. Our
                        team operates as a club out of Westwood High School and currently comprises of six FTC teams and one FRC team.
                    </p>
                    <p className="pt-5 text-lg">
                        In the offseason, we host several local robotics tournaments at our high school such as FIRST Lego League and FIRST Tech
                        Challenge competitions, as well as teaching engineering and Lego Robotics at elementary and middle schools around Round Rock
                        ISD.
                    </p>
                </div>
                <div className="flex flex-col items-center w-full">
                    <h1 className="p-0 mt-16 text-6xl font-semibold text-center text-dynamite-500">Leadership</h1>
                    <div className="grid grid-flow-row mt-12 max-w-fit sm:grid-cols-2 lg:grid-cols-4 gap-y-8 place-items-center">
                        {officer_info.map(o => (
                                <div className="w-64 h-full text-center">
                                    <Image className={"rounded-lg m-0"} src={o.img_path} alt={o.name} style={{ objectFit: "contain" }} placeholder="blur" />
                                    <h1 className="text-2xl font-semibold">{o.position}</h1>
                                    <h2 className="text-xl">{o.name}</h2>
                                </div>
                            ))}
                    </div>
                </div>
            </div>
        </>
    );
};

export default AboutPage;
